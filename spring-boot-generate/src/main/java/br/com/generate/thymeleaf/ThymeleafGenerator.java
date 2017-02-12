package br.com.generate.thymeleaf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ThymeleafGenerator extends AbstractThymeleafGenerate {

	public ThymeleafGenerator(String className, String parameters) throws IOException {
		if (validateLayoutHtml()) {
			generateTemplateLayout();
		}
		generateIndexHtml(className, parameters);
		generateFormHtml(className, parameters);
		generateShowHtml(className, parameters);
	}

	public void generateTemplateLayout() throws IOException {
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-layout.html"), null);
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/layout.html");
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/layout.html");
	}
	
	public void generateIndexHtml(String className, String parameters) throws IOException {
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-index.html"), null);
		String template = "layout";
		String classNameParam = className;
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String thAttributes = generateThParameters(parameters);
		String tdAttributes = generateTdParameters(className, parameters);
		String eachParam = "list" + className;
		
		htmlString = htmlString.replace("${template}", template);
		htmlString = htmlString.replace("${className}", classNameParam);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("eachParam", eachParam);
		htmlString = htmlString.replace("url_path", pathUrl);
		htmlString = htmlString.replace("${th_attributes}", thAttributes);
		htmlString = htmlString.replace("${td_attributes}", tdAttributes);
		
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/" + className.toLowerCase() + "/index.html");
		
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/" + className.toLowerCase() + "/index.html");
	}

	public void generateFormHtml(String className, String parameters) throws IOException {
		String htmlString =IOUtils.toString(getClass().getResourceAsStream("/templates/template-form.html"), null);
		
		String template = "layout";
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String inputParameters = generateInputParameters(parameters);
		
		htmlString = htmlString.replace("${template}", template);
		htmlString = htmlString.replace("${className}", className);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("url_path", pathUrl);
		htmlString = htmlString.replace("${input_parameters}", inputParameters);
		
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/" + className.toLowerCase() + "/form.html");
		
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/" + className.toLowerCase() + "/form.html");
	}
	
	public void generateShowHtml(String className, String parameters) throws IOException {
		String htmlString =IOUtils.toString(getClass().getResourceAsStream("/templates/template-show.html"), null);
		
		String template = "layout";
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String showAttributes = generateShowParameters(paramClassName, parameters);
		
		htmlString = htmlString.replace("${template}", template);
		htmlString = htmlString.replace("${className}", className);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("/path_url", pathUrl);
		htmlString = htmlString.replace("${showAttributes}", showAttributes);
		
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/" + className.toLowerCase() + "/show.html");
		
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/" + className.toLowerCase() + "/show.html");
	}
	
	public boolean validateLayoutHtml() throws IOException {
		String pathFile = "/src/main/resources/templates/layout.html";
		File f = new File(getUserDir() + pathFile);
		if(f.exists()) { 
			return false;
		} 
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		new ThymeleafGenerator("User", "name:String email:String");
	}
	
}
