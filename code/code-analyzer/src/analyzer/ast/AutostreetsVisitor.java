package analyzer.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class AutostreetsVisitor extends ASTVisitor {

	// 当前类所属包
	private String strPackageName;

	// import的包
	private final List<String> importPackages = new ArrayList<String>();

	// 类名
	private String strClassName;
	// 类url
	private String strParenttUrl;
	// // 类和controller-url关系
	// private final HashMap<String, String> classUrlRelation = new
	// HashMap<String, String>();

	// 类内方法和controller-url关系
	private final HashMap<String, String> methodUrlRelation = new HashMap<String, String>();

	// 类方法和被调用方法之间的关系
	private final HashMap<String, List<String>> methodInvokMethodRelation = new HashMap<String, List<String>>();

	// 被调用方法和它对象的关系
	private final HashMap<String, String> methodVariableRelation = new HashMap<String, String>();

	// 变量类型和变量的关系
	private final HashMap<String, String> variableTypeRelation = new HashMap<String, String>();

	@Override
	public boolean visit(PackageDeclaration node)
	{

		strPackageName = node.getName().getFullyQualifiedName();

		return true;
	}

	@Override
	public boolean visit(ImportDeclaration node)
	{

		String strPackageName = node.getName().toString();
		if (strPackageName.endsWith("Service")) {
			// System.out.println("importPackage: " + strPackageName);
			importPackages.add(strPackageName);
		}

		return true;
	}

	@Override
	public boolean visit(TypeDeclaration node)
	{

		strClassName = node.getName().getFullyQualifiedName();
		strParenttUrl = ASTUtil.getUrlFromModifiers(node.modifiers());
		// System.out.println("className: " + strClassName + ",\trootUrl: " +
		// strRootUrl);

		// classUrlRelation.put(strClassName, strRootUrl);

		return true;
	}

	@Override
	public boolean visit(FieldDeclaration node)
	{

		for (Object object : node.fragments()) {
			VariableDeclarationFragment v = (VariableDeclarationFragment) object;
			String strVariableName = v.getName().toString();
			String strVariableType = node.getType().toString();
			// FieldDeclaration parentNode = (FieldDeclaration)
			// v.getParent();
			// System.out.println("variableType: " + node.getType()
			// +
			// "\tvariableName: " + v.getName());

			variableTypeRelation.put(strVariableName, strVariableType);
		}
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node)
	{

		String strMethodName = node.getName().getFullyQualifiedName();
		String strChildUrl = ASTUtil.getUrlFromModifiers(node.modifiers());

		// System.out.println("classMethodName: " + strMethodName +
		// ",\tchildUrl: " + strChildUrl);

		methodUrlRelation.put(strMethodName, strChildUrl);
		return true;
	}

	@Override
	public boolean visit(MethodInvocation node)
	{

		String strVariableName = ASTUtil.getMethodInvocationName(node);
		String strInvokeMethod = node.getName().getFullyQualifiedName();
		String strParentMethod = "";

		if (strVariableName.endsWith("Service")) {
			methodVariableRelation.put(strInvokeMethod, strVariableName);
			strParentMethod = ASTUtil.getParentMethod(node);
			// System.out.println("InvokeMethod: " + strVariableName + "."
			// + strInvokeMethod + "\tParentMethod: " + strParentMethod);

			if (methodInvokMethodRelation.containsKey(strParentMethod)) {
				List<String> invokeMethods = methodInvokMethodRelation.get(strParentMethod);
				invokeMethods.add(strInvokeMethod);
			} else {
				List<String> invokeMethods = new ArrayList<String>();
				invokeMethods.add(strInvokeMethod);
				methodInvokMethodRelation.put(strParentMethod, invokeMethods);
			}
		}

		return true;
	}

	public String getPackageName()
	{

		return strPackageName;
	}

	public String getClassName()
	{

		return strClassName;
	}

	public String getParentUrl()
	{

		return strParenttUrl;
	}

	public List<String> getImportPackages()
	{

		return importPackages;
	}

	// public Map<String, String> getClassUrlRelation()
	// {
	//
	// return classUrlRelation;
	// }

	public Map<String, String> getMethodUrlRelation()
	{

		return methodUrlRelation;
	}

	public Map<String, List<String>> getMethodInvokMethodRelation()
	{

		return methodInvokMethodRelation;
	}

	public Map<String, String> getVariableTypeRelation()
	{

		return variableTypeRelation;
	}

	public Map<String, String> getMethodVariableRelation() {

		return methodVariableRelation;
	}
}
