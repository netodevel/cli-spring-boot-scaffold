package br.com.generate.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.strategy.IGenerate;

public class ServiceGenerateJava implements IGenerate {

	public ServiceGenerateJava(String className) {
		generate(className);
	}
	
	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/service/" + CLASS_NAME + "Service.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				
				String nameRepository = CLASS_NAME.toLowerCase() + "Repository";
				String nameParamObject = CLASS_NAME.toLowerCase() + "Object";
				
				writer.println("");
				
				writer.println("@Service");
				writer.println("@Transactional(readOnly = true)");
				writer.println("public class " + CLASS_NAME + "Service {");
				writer.println("");
				
				writer.println("	@Autowired");
				writer.println("	private " + CLASS_NAME + "Repository " + nameRepository + ";");
				writer.println("");

				writer.println("	public List<"+ CLASS_NAME +"> findAll() {");
				writer.println("		return " + nameRepository + ".findAll();");
				writer.println("	}");
				writer.println("");
				
				writer.println("	public "+ CLASS_NAME +" findOne(Long id) {");
				writer.println("		return " + nameRepository + ".findOne(id);");
				writer.println("	}");
				writer.println("");
				
				writer.println("	@Transactional(readOnly = false)");
				writer.println("	public " + CLASS_NAME + " save(" + CLASS_NAME + " " + nameParamObject + ") {") ;
				writer.println("		return " + nameRepository + ".save("+ nameParamObject +");");
				writer.println("	}");
				writer.println("");
				
				writer.println("	@Transactional(readOnly = false)");
				writer.println("	public void delete(" + CLASS_NAME + " " + nameParamObject + ") {") ;
				writer.println("		" + nameRepository + ".delete("+ nameParamObject +");");
				writer.println("	}");
				writer.println("");
				
				writer.println("}");
				writer.close();
				System.out.println("create src/main/java/br/com/scaffold/service/" + CLASS_NAME + "Service.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.service;");
		print.println("import org.springframework.beans.factory.annotation.Autowired;");
		print.println("import br.com.scaffold.model." + namesClass[0] + ";");
		print.println("import br.com.scaffold.repository." + namesClass[0] + "Repository;");
		print.println("import org.springframework.stereotype.Service;");
		print.println("import org.springframework.transaction.annotation.Transactional;");
		print.println("import java.util.List;");
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/service/" + nameFile + "Service.java");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}

}
