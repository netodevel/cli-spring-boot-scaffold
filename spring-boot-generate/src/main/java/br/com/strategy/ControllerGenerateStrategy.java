package br.com.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Provider the generate of a controller
 * @author NetoDevel
 * @since 0.0.1
 *
 */
public class ControllerGenerateStrategy implements IGenerate {

	public ControllerGenerateStrategy(String optionValue) {
		generate(optionValue);
	}

	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/controller/" + CLASS_NAME + "Controller.kt");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				
				String nameService = CLASS_NAME.toLowerCase() + "Service";
				String nameParamObject = CLASS_NAME.toLowerCase();
				
				writer.println("");
				writer.println("@RestController");
				writer.println("class " + CLASS_NAME + "Controller {");
				writer.println("");
				writer.println("	@Autowired");
				writer.println("	lateinit var " + nameService + ":" + CLASS_NAME + "Service");
				writer.println("");
				writer.println("	@GetMapping(\""+ CLASS_NAME.toLowerCase() + "s" +"\") ");
				writer.println("	fun index() = " + nameService + ".index()");
				writer.println("");
				writer.println("	@PostMapping(\"" + CLASS_NAME.toLowerCase() + "\") ");
				writer.println("	fun create(@RequestBody " + nameParamObject + ": " + CLASS_NAME + ") = " + nameService + ".create(" + nameParamObject + ")");
				writer.println("");
				writer.println("	@PutMapping(\"" + CLASS_NAME.toLowerCase() + "\") ");
				writer.println("	fun update(@RequestBody " + nameParamObject + ": " + CLASS_NAME + ") = " + nameService + ".update(" + nameParamObject + ")");
				writer.println("");
				writer.println("	@DeleteMapping(\"" + CLASS_NAME.toLowerCase() + "\") ");
				writer.println("	fun delete(@RequestBody " + nameParamObject + ": " + CLASS_NAME + ") = " + nameService + ".delete(" + nameParamObject + ")");
				writer.println("");
				writer.println("	@GetMapping(\"" + CLASS_NAME.toLowerCase() + "/{id}" + "\") ");
				writer.println("	fun show(@PathVariable(\"id\") id:Long) = " + nameService + ".findOne(id)");
				writer.println("");
				writer.println("}");
				writer.close();
				System.out.println("invoke springframework.web.bind.annotation.RestController");
				System.out.println("create src/main/java/br/com/scaffold/controller/" + CLASS_NAME + "Controller.kt");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.controller");
		print.println("import org.springframework.web.bind.annotation.RestController");
		print.println("import org.springframework.beans.factory.annotation.Autowired");
		print.println("import org.springframework.web.bind.annotation.GetMapping");
		print.println("import org.springframework.web.bind.annotation.PostMapping");
		print.println("import org.springframework.web.bind.annotation.RequestBody");
		print.println("import org.springframework.web.bind.annotation.RequestParam");
		print.println("import org.springframework.web.bind.annotation.PutMapping");
		print.println("import org.springframework.web.bind.annotation.DeleteMapping");
		print.println("import org.springframework.web.bind.annotation.PathVariable");
		
		print.println("import br.com.scaffold.model." + namesClass[0]);
		print.println("import br.com.scaffold.service." + namesClass[0] + "Service");
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/controller/" + nameFile + "Controller.kt");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}

}
