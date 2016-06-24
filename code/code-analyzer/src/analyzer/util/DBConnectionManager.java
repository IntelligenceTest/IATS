package analyzer.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

public class DBConnectionManager {

	private static DBConnectionManager instance;
	private static int clients;
	private final Vector drivers = new Vector();
	private PrintWriter log;
	private final Hashtable pools = new Hashtable();

	public static synchronized DBConnectionManager getInstance() throws FileNotFoundException {

		if (instance == null) {
			instance = new DBConnectionManager();
		}
		clients += 1;
		return instance;
	}

	private DBConnectionManager() throws FileNotFoundException {

		init();
	}

	public void freeConnection(String name, Connection con) {

		DBConnectionPool pool = (DBConnectionPool) this.pools.get(name);
		if (pool != null)
			pool.freeConnection(con);
	}

	public Connection getConnection(String name) {

		DBConnectionPool pool = (DBConnectionPool) this.pools.get(name);
		if (pool != null) {
			return pool.getConnection();
		}
		return null;
	}

	public Connection getConnection(String name, long time) {

		DBConnectionPool pool = (DBConnectionPool) this.pools.get(name);
		if (pool != null) {
			return pool.getConnection(time);
		}
		return null;
	}

	public synchronized void release() {

		if (--clients != 0) {
			return;
		}

		Enumeration allPools = this.pools.elements();
		while (allPools.hasMoreElements()) {
			DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
			pool.release();
		}
		Enumeration allDrivers = this.drivers.elements();
		while (allDrivers.hasMoreElements()) {
			Driver driver = (Driver) allDrivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				log("撤销JDBC驱动程序 " + driver.getClass().getName() + "的注册");
			} catch (SQLException e) {
				log(e, "无法撤销下列JDBC驱动程序的注册: " + driver.getClass().getName());
			}
		}
	}

	private void createPools(Properties props) {

		Enumeration propNames = props.propertyNames();
		while (propNames.hasMoreElements()) {
			String name = (String) propNames.nextElement();
			if (name.endsWith(".url")) {
				String poolName = name.substring(0, name.lastIndexOf("."));
				String url = props.getProperty(poolName + ".url");
				if (url == null) {
					log("没有为连接池" + poolName + "指定URL");
				}

				String user = props.getProperty(poolName + ".user");
				String password = props.getProperty(poolName + ".password");
				String maxconn = props.getProperty(poolName + ".maxconn", "0");
				String encoding = props.getProperty(poolName + ".encoding");
				int max;
				try {
					max = Integer.valueOf(maxconn).intValue();
				} catch (NumberFormatException e) {
					log("错误的最大连接数限制: " + maxconn + " .连接池: " + poolName);
					max = 0;
				}
				DBConnectionPool pool = new DBConnectionPool(poolName, url, user, password, max, encoding);
				this.pools.put(poolName, pool);
				log("成功创建连接池" + poolName);
			}
		}
	}

	private void init() throws FileNotFoundException {

		// InputStream is =
		// super.getClass().getResourceAsStream("/jdbc.properties");

		FileInputStream file = new FileInputStream("conf/jdbc.properties");
		Properties dbProps = new Properties();
		try {
			dbProps.load(file);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		// String logFile = dbProps.getProperty("logfile", "logs\\newslog.txt");
		// try {
		// this.log = new PrintWriter(new FileWriter(logFile, true), true);
		// } catch (IOException e) {
		// System.err.println("无法打开日志文件: " + logFile);
		// this.log = new PrintWriter(System.err);
		// }
		loadDrivers(dbProps);
		createPools(dbProps);
	}

	private void loadDrivers(Properties props) {

		String driverClasses = props.getProperty("driver");
		StringTokenizer st = new StringTokenizer(driverClasses);
		while (st.hasMoreElements()) {
			String driverClassName = st.nextToken().trim();
			try {
				Driver driver = (Driver) Class.forName(driverClassName).newInstance();

				DriverManager.registerDriver(driver);
				this.drivers.addElement(driver);
				log("成功注册JDBC驱动程序" + driverClassName);
			} catch (Exception e) {
				log("无法注册JDBC驱动程序: " + driverClassName + ", 错误: " + e);
			}
		}
	}

	private void log(String msg) {

		// log.println(new Date() + ": " + msg);
	}

	private void log(Throwable e, String msg) {

		// log.println(new Date() + ": " + msg);
		// e.printStackTrace(log);
	}

	class DBConnectionPool {

		private int checkedOut;
		private final Vector freeConnections = new Vector();
		private final int maxConn;
		private final String name;
		private final String password;
		private final String URL;
		private final String user;
		private String databaseUrl;
		private final String characterEncoding;

		public DBConnectionPool(String name, String URL, String user, String password, int maxConn, String characterEncoding) {

			this.name = name;
			this.URL = URL;
			this.user = user;
			this.password = password;
			this.maxConn = maxConn;
			this.characterEncoding = characterEncoding;
		}

		public synchronized void freeConnection(Connection con) {

			this.freeConnections.addElement(con);
			this.checkedOut -= 1;
			super.notifyAll();
		}

		public synchronized Connection getConnection() {

			Connection con = null;
			if (freeConnections.size() > 0) {
				// 获取向量中第一个可用连接
				con = (Connection) freeConnections.firstElement();
				freeConnections.removeElementAt(0);
				try {
					if (!con.isValid(30)) {
						log("从连接池" + name + "删除一个无效连接");
						// System.out.println("从连接池" + name + "删除一个无效连接");
						// 递归调用自己,尝试再次获取可用连接
						con = getConnection();
					}
				} catch (SQLException e) {
					log("从连接池" + name + "删除一个无效连接时错误");
					System.out.println("从连接池" + name + "删除一个无效连接出错");
					// 递归调用自己,尝试再次获取可用连接
					con = getConnection();
				}
				if (freeConnections.size() > maxConn) {
					System.out.println(" 删除一个溢出连接 ");
					releaseOne();
				}
			}

			else if ((maxConn == 0) || (freeConnections.size() < maxConn)) {
				con = newConnection();
			}

			return con;
		}

		public synchronized Connection getConnection(long timeout) {

			long startTime = new Date().getTime();
			Connection con;
			while ((con = getConnection()) == null) {
				try {
					super.wait(timeout);
				} catch (InterruptedException e) {
				}
				if (new Date().getTime() - startTime >= timeout) {
					return null;
				}
			}
			return con;
		}

		public synchronized void release() {

			Enumeration allConnections = this.freeConnections.elements();
			while (allConnections.hasMoreElements()) {
				Connection con = (Connection) allConnections.nextElement();
				try {
					con.close();
					DBConnectionManager.this.log("关闭连接池" + this.name + "中的一个连接");
				} catch (SQLException e) {
					DBConnectionManager.this.log(e, "无法关闭连接池" + this.name + "中的连接");
				}
			}
			this.freeConnections.removeAllElements();
		}

		/**
		 * 关闭一个连接
		 */
		public synchronized void releaseOne() {

			if (freeConnections.firstElement() != null) {
				Connection con = (Connection) freeConnections.firstElement();
				try {
					con.close();
					// System.out.println("关闭连接池" + name + "中的一个连接");
					log("关闭连接池" + name + "中的一个连接");
				} catch (SQLException e) {

					System.out.println("无法关闭连接池" + name + "中的一个连接");
					log(e, "无法关闭连接池" + name + "中的连接");
				}
			} else {
				System.out
						.println("releaseOne() bug.......................................................");

			}
		}

		private Connection newConnection() {

			Connection con = null;
			try {
				if (this.user == null) {
					con = DriverManager.getConnection(this.URL);
				} else {
					String tmpURL = this.URL + "?user=" + this.user + "&password=" + this.password
							+ "&useUnicode=true&characterEncoding=" + this.characterEncoding;

					con = DriverManager.getConnection(tmpURL);
				}
				DBConnectionManager.this.log("连接池" + this.name + "创建一个新的连接");
			} catch (SQLException e) {
				DBConnectionManager.this.log(e, "无法创建下列URL的连接: " + this.URL);
				return null;
			}
			return con;
		}

	}
}
