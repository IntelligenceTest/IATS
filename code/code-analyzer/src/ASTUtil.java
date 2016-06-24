import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

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
}
