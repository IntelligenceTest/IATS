package com.autostreets.biz.auction.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * 自动生成dubbo-resolve.properties<br>
 * 自动生成dubbo-resolve.properties,让应用直连本机dubbo服务
 *
 * @author weiyi.wang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GenerateProperties {

	private static final String LOCAL_SERVICE_URL = "dubbo://localhost:20880";

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException {
		System.out.println("开始生成dubbo-resolve.properties文件");
		System.out.println("获取用户目录：" + System.getProperty("user.home"));
		System.out.println("开始删除本地dubbo缓存信息...");
		File dubboDir = new File(System.getProperty("user.home") + "/.dubbo");
		if (dubboDir.isDirectory()) {
			File[] files = dubboDir.listFiles();
			for (File file : files) {
				System.out.println("已删除" + file.getAbsolutePath());
				file.delete();
			}
			System.out.println("已删除本地dubbo缓存目录");
			dubboDir.delete();
		}
		File propertiesFile = new File(System.getProperty("user.home") + File.separator + "dubbo-resolve.properties");
		FileWriter fileWriter = null;
		String selfConfigStr = "";
		Boolean hasSelfConfig = false;
		if (!propertiesFile.exists()) {
			System.out.println("文件不存在!创建新文件!");
			propertiesFile.createNewFile();// 创建新文件
		} else {
			FileReader fileReader = new FileReader(propertiesFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String configStr = null;
			while ((configStr = bufferedReader.readLine()) != null) {
				if (hasSelfConfig) {
					selfConfigStr += configStr + "\n";
				}
				if (configStr.startsWith("#selfConfig")) {
					hasSelfConfig = true;
				}
			}
			bufferedReader.close();
			fileReader.close();
		}
		try {
			fileWriter = new FileWriter(propertiesFile);
			System.out.println("获取dubbo-service.xml文件");
			InputStream is = GenerateProperties.class.getClassLoader()
					.getResourceAsStream("META-INF/spring/autostreets-dubbo-service.xml");
			System.out.println("开始解析...");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);
			List<Element> elements = doc.getRootElement().elements();
			String interfaceName = "";
			for (Element element : elements) {
				if ("service".equals(element.getName())) {
					interfaceName = element.attributeValue("interface");
					fileWriter.write(interfaceName + "=" + LOCAL_SERVICE_URL + "\n");
				}
			}
			if (hasSelfConfig) {
				fileWriter.write("#selfConfig\n");
				fileWriter.write(selfConfigStr);
			}
			System.out.println("生成成功!文件路径" + propertiesFile.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
