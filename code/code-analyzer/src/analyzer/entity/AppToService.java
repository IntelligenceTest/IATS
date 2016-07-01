package analyzer.entity;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class AppToService {

	// 应用名称
	private String name;

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
	private String methodName;

	// 类方法的url
	private String childUrl;

	// 调用的服务
	private String invokeService;

	// 调用的方法
	private String invokeMethod;

	private Date createdTime;

	public String getName() {

		return name;
	}

	public void setName(String appName) {

		this.name = appName;
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

	public String getMethodName() {

		return methodName;
	}

	public void setMethodName(String appMethodName) {

		this.methodName = appMethodName;
	}

	public String getChildUrl() {

		return childUrl;
	}

	public void setChildUrl(String childUrl) {

		this.childUrl = childUrl;
	}

	public String getInvokeService() {

		return invokeService;
	}

	public void setInvokeService(String serviceName) {

		this.invokeService = serviceName;
	}

	public String getInvokeMethod() {

		return invokeMethod;
	}

	public void setInvokeMethod(String serviceMethodName) {

		this.invokeMethod = serviceMethodName;
	}

	public String getCreatedTime() {

		return DateFormatUtils.ISO_DATETIME_FORMAT.format(createdTime);
	}

	public void setCreatedTime(Date createdTime) {

		this.createdTime = createdTime;
	}

	@Override
	public String toString() {

		return "AppToService [name=" + name + ", projectName=" + projectName + ", sourceFile=" + sourceFile
				+ ", packageName=" + packageName + ", className=" + className + ", parentUrl=" + parentUrl
				+ ", appMethodName="
				+ methodName + ", childUrl=" + childUrl + ", invokeService=" + invokeService + ", invokeMethod="
				+ invokeMethod + ", createdTime=" + createdTime + "]";
	}
}
