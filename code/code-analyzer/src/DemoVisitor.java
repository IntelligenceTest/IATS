import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class DemoVisitor extends ASTVisitor {

	@Override
	public boolean visit(TypeDeclaration node)
	{

		String strClassName = node.getName().getFullyQualifiedName();
		String strRootUrl = getUrlFromModifiers(node.modifiers());
		System.out.println("className: " + strClassName + ",\trootUrl: " + strRootUrl);

		// List<StructuralPropertyDescriptor> types =
		// node.structuralPropertiesForType();
		//
		// for (StructuralPropertyDescriptor object : types) {
		//
		// // System.out.println(object.getClass());
		//
		// if (object instanceof ChildListPropertyDescriptor) {
		// ChildListPropertyDescriptor spd = (ChildListPropertyDescriptor)
		// object;
		// if (spd.getId().equals("modifiers")) {
		// List<IExtendedModifier> t = (List<IExtendedModifier>)
		// node.getStructuralProperty(spd);
		// for (IExtendedModifier item : t) {
		// item
		// }
		//
		// // System.out.println(node.getStructuralProperty(spd).getClass());
		// }
		//
		// }
		// }

		// try {
		// for (Object o : node.modifiers()) {
		// System.out.println(o.getClass());
		//
		// if (o instanceof SingleMemberAnnotation) {
		// Annotation singleMemberAnnotation = (Annotation) o;
		// String strAnnotationName =
		// singleMemberAnnotation.getTypeName().getFullyQualifiedName();
		//
		// System.out.println(strAnnotationName);
		// if (strAnnotationName.equals("RequestMapping")) {
		// // System.out.println(singleMemberAnnotation.);
		// }
		// }
		//
		// }
		// } catch (Exception e) {
		// return true;
		// }

		return true;
	}

	@Override
	public boolean visit(ImportDeclaration node)
	{

		String strPackageName = node.getName().toString();
		if (strPackageName.endsWith("Service")) {
			System.out.println("importPackage: " + strPackageName);
		}

		return true;
	}

	@Override
	public boolean visit(FieldDeclaration node)
	{

		for (Object object : node.fragments()) {
			VariableDeclarationFragment v = (VariableDeclarationFragment) object;
			String strVariableName = v.getName().toString();

			// FieldDeclaration parentNode = (FieldDeclaration)
			// v.getParent();
			System.out.println("variableType: " + node.getType()
					+
					"\tvariableName: " + v.getName());

		}
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node)
	{

		String strMethodName = node.getName().getFullyQualifiedName();
		String strChildUrl = getUrlFromModifiers(node.modifiers());

		System.out.println("classMethodName: " + strMethodName + ",\tchildUrl: " + strChildUrl);

		return true;
	}

	@Override
	public boolean visit(MethodInvocation node)
	{

		String strVariableName = getMethodInvocationName(node);
		String strInvokeMethod = node.getName().getFullyQualifiedName();
		String strParentMethod = "";

		if (strVariableName.endsWith("Service")) {
			strParentMethod = getParentMethod(node);
			System.out.println("InvokeMethod: " + strVariableName + "."
					+ strInvokeMethod + "\tParentMethod: " + strParentMethod);
		}

		return true;
	}

	private static String getUrlFromModifiers(List modifiers)
	{

		String strUrl = "";

		for (Object object : modifiers) {
			if (object instanceof SingleMemberAnnotation) {
				SingleMemberAnnotation sma = (SingleMemberAnnotation) object;
				String strName = sma.getTypeName().getFullyQualifiedName();
				if (strName.equals("RequestMapping")) {
					Object objValue = sma.getValue();
					if (objValue instanceof ArrayInitializer) {
						ArrayInitializer ai = (ArrayInitializer) objValue;

						if (ai.expressions().size() > 0) {
							StringLiteral sl = (StringLiteral) ai.expressions().get(0);
							strUrl = sl.getLiteralValue();
						}
					} else if (objValue instanceof StringLiteral) {
						StringLiteral sl = (StringLiteral) objValue;
						strUrl = sl.getLiteralValue();
					}
				}
			}

			if (object instanceof NormalAnnotation) {
				NormalAnnotation na = (NormalAnnotation) object;
				List<MemberValuePair> memberValuePairs = na.values();
				for (MemberValuePair memberValuePair : memberValuePairs) {

					String strName = memberValuePair.getName().getFullyQualifiedName();
					if (strName.equals("value")) {
						Object objValue = memberValuePair.getValue();
						if (objValue instanceof ArrayInitializer) {
							ArrayInitializer ai = (ArrayInitializer) objValue;
							if (ai.expressions().size() > 0) {
								StringLiteral sl = (StringLiteral) ai.expressions().get(0);
								strUrl = sl.getLiteralValue();
							}

						} else if (objValue instanceof StringLiteral) {
							StringLiteral sl = (StringLiteral) objValue;
							strUrl = sl.getLiteralValue();
						}
					}
				}
			}
		}
		return strUrl;
	}

	private static void getMethodNameByInvokMethod(ASTNode node)
	{

	}

	private static String getParentMethod(ASTNode node)
	{

		String strParentMethod = "";

		ASTNode parent = node.getParent();
		if (parent.getLocationInParent().getNodeClass().equals(MethodDeclaration.class))
		{
			MethodDeclaration md = (MethodDeclaration) parent.getParent();
			strParentMethod = md.getName().getFullyQualifiedName();
		} else {
			return getParentMethod(parent);
		}
		return strParentMethod;
	}

	private static String getMethodInvocationName(MethodInvocation node)
	{

		String strName = "";
		Expression expression = node.getExpression();
		if (expression != null) {
			if (expression.getClass().equals(MethodInvocation.class)) {
				MethodInvocation md = (MethodInvocation) expression;
				return getMethodInvocationName(md);
			} else if (expression.getClass().equals(SimpleName.class)) {
				strName = expression.toString();
			}
		}
		return strName;
	}
}
