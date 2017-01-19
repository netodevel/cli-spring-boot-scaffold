package br.com.generate.kotlin.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

/**
 * Provider the generate of a service
 * @author Jose
 * @since 0.0.1
 */
public class ServiceGenerateKotlin implements IBaseScaffold {

	public ServiceGenerateKotlin(String optionValue) {
		generate(optionValue);
	}

	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/service/" + CLASS_NAME + "Service.kt");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				
				String nameRepository = CLASS_NAME.toLowerCase() + "Repository";
				String nameParamObject = CLASS_NAME.toLowerCase() + "Object";
				
				writer.println("");
				writer.println("@Service");
				writer.println("class " + CLASS_NAME + "Service {");
				writer.println("");
				writer.println("	@Autowired");
				writer.println("	lateinit var " + nameRepository + ":" + CLASS_NAME + "Repository");
				writer.println("");
				writer.println("	fun index() = " + nameRepository + ".findAll()");
				writer.println("");
				writer.println("	fun create(" + nameParamObject + ": " + CLASS_NAME + ") = " + nameRepository + ".save(" + nameParamObject + ")");
				writer.println("");
				writer.println("	fun update(" + nameParamObject + ": " + CLASS_NAME + ") = " + nameRepository + ".save(" + nameParamObject + ")");
				writer.println("");
				writer.println("	fun delete(" + nameParamObject + ": " + CLASS_NAME + ") = " + nameRepository + ".delete(" + nameParamObject + ")");
				writer.println("");
				writer.println("	fun findOne(id: Long) =  " + nameRepository + ".findOne(id)");
				writer.println("");
				writer.println("}");
				writer.close();
				System.out.println("invoke springframework.stereotype.Service");
				System.out.println("create src/main/java/br/com/scaffold/service/" + CLASS_NAME + "Service.kt");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.service");
		print.println("import org.springframework.beans.factory.annotation.Autowired");
		print.println("import br.com.scaffold.model." + namesClass[0]);
		print.println("import br.com.scaffold.repository." + namesClass[0] + "Repository");
		print.println("import org.springframework.stereotype.Service");
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/service/" + nameFile + "Service.kt");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}

}
