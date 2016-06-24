package analyzer.bean;

import java.util.Date;

public class AppToService {

	// 应用名称
	private String appName;

	// 应用工程名
	private String projectName;

	// 代码源文件
	private String sourceFile;

	// 包名
	private String packageName;

	// 类名
	private String className;

	// 主url
	private String parentUrl;

	// 类的方法
	private String appMethodName;

	// 类方法的url
	private String childUrl;

	// 服务名
	private String serviceName;

	// 服务方法名
	private String serviceMethodName;

	private Date createdTime;

	public String getAppName() {

		return appName;
	}

	public void setAppName(String appName) {

		this.appName = appName;
	}

	public String getProjectName() {

		return projectName;
	}

	public void setProjectName(String projectName) {

		this.projectName = projectName;
	}

	public String getSourceFile() {

		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {

		this.sourceFile = sourceFile;
	}

	public String getPackageName() {

		return packageName;
	}

	public void setPackageName(String packageName) {

		this.packageName = packageName;
	}

	public String getClassName() {

		return className;
	}

	public void setClassName(String className) {

		this.className = className;
	}

	public String getParentUrl() {

		return parentUrl;
	}

	public void setParentUrl(String parentUrl) {

		this.parentUrl = parentUrl;
	}

	public String getAppMethodName() {

		return appMethodName;
	}

	public void setAppMethodName(String appMethodName) {

		this.appMethodName = appMethodName;
	}

	public String getChildUrl() {

		return childUrl;
	}

	public void setChildUrl(String childUrl) {

		this.childUrl = childUrl;
	}

	public String getServiceName() {

		return serviceName;
	}

	public void setServiceName(String serviceName) {

		this.serviceName = serviceName;
	}

	public String getServiceMethodName() {

		return serviceMethodName;
	}

	public void setServiceMethodName(String serviceMethodName) {

		this.serviceMethodName = serviceMethodName;
	}

	public Date getCreatedTime() {

		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {

		this.createdTime = createdTime;
	}

	@Override
	public String toString() {

		return "AppToService [appName=" + appName + ", projectName=" + projectName + ", sourceFile=" + sourceFile
				+ ", packageName=" + packageName + ", className=" + className + ", parentUrl=" + parentUrl
				+ ", appMethodName="
				+ appMethodName + ", childUrl=" + childUrl + ", serviceName=" + serviceName + ", serviceMethodName="
				+ serviceMethodName + ", createdTime=" + createdTime + "]";
	}
}
