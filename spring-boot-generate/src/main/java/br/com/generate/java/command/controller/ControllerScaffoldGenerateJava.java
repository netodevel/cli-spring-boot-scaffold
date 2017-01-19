package br.com.generate.java.command.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

public class ControllerScaffoldGenerateJava implements IBaseScaffold {

	public ControllerScaffoldGenerateJava(String className) {
		generate(className);
	}
	
	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/controller/" + CLASS_NAME + "Controller.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				
				String nameService = CLASS_NAME.toLowerCase() + "Service";
				String nameParamObject = CLASS_NAME.toLowerCase();
				String urlName = CLASS_NAME.toLowerCase() + "s";
				
				writer.println("");
				writer.println("@RestController");
				writer.println("public class " + CLASS_NAME + "Controller {");
				writer.println("");
				
				writer.println("	@Autowired");
				writer.println("	private " + CLASS_NAME + "Service " + nameService + ";");
				writer.println("");
				
				/**
				 * GET INDEX
				 */
				writer.println("	@GetMapping(\"/"+ urlName +"\") ");
				writer.println("	public List<"+CLASS_NAME+"> index() {");
				writer.println("		return " + nameService + ".findAll();");
				writer.println("	}");
				writer.println("");
				
				/**
				 * GET SHOW
				 */
				writer.println("	@GetMapping(\"/"+ urlName +"/{id} \") ");
				writer.println("	public "+CLASS_NAME+" show(@PathVariable(\"id\") Long id) {");
				writer.println("		return " + nameService + ".findOne(id);");
				writer.println("	}");
				writer.println("");
				
				/**
				 * POST 
				 */
				writer.println("	@PostMapping(\"/"+ urlName +"\")");
				writer.println("	public "+CLASS_NAME+" create(@RequestBody "+CLASS_NAME+" " + nameParamObject + ") {");
				writer.println("		return " + nameService + ".save(" + nameParamObject + ");");
				writer.println("	}");
				writer.println("");

				/**
				 * PUT 
				 */
				writer.println("	@PutMapping(\"/"+ urlName +"\")");
				writer.println("	public "+CLASS_NAME+" update(@RequestBody "+CLASS_NAME+" " + nameParamObject + ") {");
				writer.println("		return " + nameService + ".save(" + nameParamObject + ");");
				writer.println("	}");
				writer.println("");
				
				/**
				 * DELETE 
				 */
				writer.println("	@DeleteMapping(\"/"+ urlName +"/{id} \")");
				writer.println("	public void delete(@PathVariable(\"id\") Long id) {");
				writer.println("		" + CLASS_NAME + " " + nameParamObject + " = " + nameService + ".findOne(id);");
				writer.println("		" + nameService + ".delete(" + nameParamObject + ");");
				writer.println("	}");
				writer.println("");
				
				writer.println("}");
				writer.close();
				System.out.println("create src/main/java/br/com/scaffold/controller/" + CLASS_NAME + "Controller.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.controller;");
		print.println("import org.springframework.web.bind.annotation.RestController;");
		print.println("import org.springframework.beans.factory.annotation.Autowired;");
		print.println("import org.springframework.web.bind.annotation.GetMapping;");
		print.println("import org.springframework.web.bind.annotation.PostMapping;");
		print.println("import org.springframework.web.bind.annotation.RequestBody;");
		print.println("import org.springframework.web.bind.annotation.PutMapping;");
		print.println("import org.springframework.web.bind.annotation.DeleteMapping;");
		print.println("import org.springframework.web.bind.annotation.PathVariable;");
		print.println("import java.util.List;");
		print.println("import br.com.scaffold.model." + namesClass[0] + ";");
		print.println("import br.com.scaffold.service." + namesClass[0] + "Service;");
	}

	@Override
	public String generateParams(String params) {
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/controller/" + nameFile + "Controller.java");
		if(f.exists()) { 
			System.out.println(nameFile + "Controller already exists!");
			return false;
		} else {
			return true;
		}
	}

}
