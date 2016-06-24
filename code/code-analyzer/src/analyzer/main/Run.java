package analyzer.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.jdt.core.dom.CompilationUnit;

import analyzer.ast.ASTUtil;
import analyzer.ast.AutostreetsVisitor;
import analyzer.bean.AppToService;

public class Run {

	public static void main(String[] args) {

		String strFilePath = "G:/temp-temp-temp/scancode/CashController.java";
		System.out.println("正在扫描: " + strFilePath);

		List<AppToService> datas = analyzeAppSourceFile(new File(strFilePath));
		for (AppToService appToService : datas) {
			System.out.println(appToService);
		}
	}

	private static List<File> searchAppSourceFile() {

		List<File> files = new ArrayList<File>();
		File workDir = new File("source/");
		for (File childFile : workDir.listFiles()) {
			for (File file : childFile.listFiles()) {
				file.exists()
			}
		}
		
		

	}

	private static boolean isExistProject() {

	}

	private static List<AppToService> analyzeAppSourceFile(File file) {

		CompilationUnit result = ASTUtil.getCompilationUnit(file);
		AutostreetsVisitor av = new AutostreetsVisitor();
		result.accept(av);

		String strPackageName = av.getPackageName();
		String strClassName = av.getClassName();
		String strParentUrl = av.getParentUrl();
		List<String> importPackages = av.getImportPackages();

		// Map<String, String> classUrlRelations = av.getClassUrlRelation();
		Map<String, String> methodVariableRelation = av.getMethodVariableRelation();
		Map<String, String> methodUrlRelation = av.getMethodUrlRelation();
		Map<String, List<String>> methodInvokMethodRelation = av.getMethodInvokMethodRelation();
		Map<String, String> variableTypeRelation = av.getVariableTypeRelation();
		List<AppToService> datas = new ArrayList<AppToService>();
		for (String key : methodInvokMethodRelation.keySet()) {
			List<String> invokeMethods = methodInvokMethodRelation.get(key);
			for (String invokeMethod : invokeMethods) {
				String strServiceName = "";

				String strVariable = methodVariableRelation.get(invokeMethod);
				String strType = variableTypeRelation.get(strVariable);
				for (String importPackage : importPackages) {
					if (importPackage.endsWith(strType)) {
						strServiceName = importPackage;
					}
				}

				AppToService appToService = new AppToService();
				appToService.setSourceFile(file.getPath());
				appToService.setPackageName(strPackageName);
				appToService.setClassName(strClassName);
				appToService.setParentUrl(strParentUrl);
				appToService.setServiceMethodName(invokeMethod);
				appToService.setAppMethodName(key);
				appToService.setChildUrl(methodUrlRelation.get(key));
				appToService.setCreatedTime(new java.util.Date());
				appToService.setServiceName(strServiceName);
				datas.add(appToService);
			}
		}
		return datas;
	}
}