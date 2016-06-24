package analyzer.ast;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;

public class ASTUtil {

	public static CompilationUnit getCompilationUnit(File javaFile)
	{

		CompilationUnit result = null;
		try {

			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setKind(ASTParser.K_COMPILATION_UNIT); // to parse
															// compilation
			// unit
			String strFileContent = FileUtils.readFileToString(javaFile);
			parser.setSource(strFileContent.toCharArray()); // content is a
															// string
															// which
			// stores the java source
			parser.setResolveBindings(true);
			result = (CompilationUnit) parser.createAST(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static String getUrlFromModifiers(List modifiers)
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

	public static void getMethodNameByInvokMethod(ASTNode node)
	{

	}

	public static String getParentMethod(ASTNode node)
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

	public static String getMethodInvocationName(MethodInvocation node)
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
