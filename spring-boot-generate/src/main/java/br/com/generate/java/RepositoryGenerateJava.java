package br.com.generate.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

public class RepositoryGenerateJava implements IBaseScaffold {
	
	public RepositoryGenerateJava(String className) {
		generate(className);
	}
	
	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/repository/" + CLASS_NAME + "Repository.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				writer.println("");
				writer.println("public interface " + CLASS_NAME + "Repository extends JpaRepository<" + CLASS_NAME + ", Long> {");
				writer.println("}");
				writer.close();
				System.out.println("create src/main/java/br/com/scaffold/repository/" + CLASS_NAME + "Repository.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.repository;");
		print.println("import org.springframework.data.jpa.repository.JpaRepository;");
		print.println("import br.com.scaffold.model." + namesClass[0] + ";");
	}

	@Override
	public String generateParams(String params) {
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/repository/" + nameFile + ".java");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}

}
