package analyzer.entity;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class ServiceToService {

	// 服务唯一名称
	private String name;

	// 服务工程名
	private String projectName;

	// 代码源文件
	private String sourceFile;

	// 包名
	private String packageName;

	// 实现类
	private String className;

	// 服务名
	private String serviceName;

	// 方法名
	private String methodName;

	// 调用的service
	private String invokeService;

	// 调用的方法
	private String invokeMethod;

	private Date createdTime;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
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

	public String getServiceName() {

		return serviceName;
	}

	public void setServiceName(String serviceName) {

		this.serviceName = serviceName;
	}

	public String getMethodName() {

		return methodName;
	}

	public void setMethodName(String methodName) {

		this.methodName = methodName;
	}

	public String getInvokeService() {

		return invokeService;
	}

	public void setInvokeService(String invokeService) {

		this.invokeService = invokeService;
	}

	public String getInvokeMethod() {

		return invokeMethod;
	}

	public void setInvokeMethod(String invokeMethod) {

		this.invokeMethod = invokeMethod;
	}

	public String getCreatedTime() {

		return DateFormatUtils.ISO_DATETIME_FORMAT.format(createdTime);
	}

	public void setCreatedTime(Date createdTime) {

		this.createdTime = createdTime;
	}

	@Override
	public String toString() {

		return "ServiceToService [name=" + name + ", projectName=" + projectName + ", sourceFile=" + sourceFile
				+ ", packageName=" + packageName + ", className=" + className + ", serviceName=" + serviceName
				+ ", methodName=" + methodName + ", invokeService=" + invokeService + ", invokeMethod=" + invokeMethod
				+ ", createdTime=" + createdTime + "]";
	}

}
