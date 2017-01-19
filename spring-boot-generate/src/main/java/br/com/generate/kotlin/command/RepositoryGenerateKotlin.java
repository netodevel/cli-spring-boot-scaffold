package br.com.generate.kotlin.command;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

/**
 * Provider the generate of a repository JPA
 * @author Jose
 * @since 0.0.1
 */
public class RepositoryGenerateKotlin implements IBaseScaffold {

	public RepositoryGenerateKotlin(String optionValue) {
		generate(optionValue);
	}

	public void generate(String... params) {
		String CLASS_NAME = params[0];
		
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/repository/" + CLASS_NAME + "Repository.kt");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				writer.println("");
				writer.println("interface " + CLASS_NAME + "Repository : JpaRepository<" + CLASS_NAME + ", Long> {");
				writer.println("}");
				writer.close();
				System.out.println("invoke spring data-jpa");
				System.out.println("create src/main/java/br/com/scaffold/repository/" + CLASS_NAME + "Repository.kt");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}
	
	public void imports(PrintWriter print, String[] nameClass) {
		print.println("package br.com.scaffold.repository");
		print.println("import org.springframework.data.jpa.repository.JpaRepository");
		print.println("import br.com.scaffold.model." + nameClass[0]);
	}

	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/repository/" + nameFile + ".kt");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String generateParams(String params) {
		return null;
	}
	
}
