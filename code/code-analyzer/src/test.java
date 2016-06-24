import java.io.File;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class test {

	public static void main(String[] args) throws Exception {

		String strFilePath = "G:/temp-temp-temp/scancode/CashController.java";
		// System.out.println("正在扫描: " + strFilePath);

		CompilationUnit result = ASTUtil.getCompilationUnit(new File(strFilePath));

		// java.util.List typeDeclarations = result.types();
		// TypeDeclaration clazz = (TypeDeclaration) typeDeclarations.get(0);
		// System.out.println("Class Name:" + clazz.getName());
		// // for (Object obj : clazz.modifiers()) { // 得到修辞符如：public,static,
		// // // abstract,
		// Annotation modifier = (Annotation) clazz.modifiers().get(1);
		// System.out.println(modifier.getTypeName());

		DemoVisitor dv = new DemoVisitor();
		result.accept(dv);

	}

	private static CompilationUnit parse(String content) {

		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT); // to parse compilation
		// unit
		parser.setSource(content.toCharArray()); // content is a string which
		// stores the java source
		parser.setResolveBindings(true);
		CompilationUnit result = (CompilationUnit) parser.createAST(null);
		return result;
	}
}
