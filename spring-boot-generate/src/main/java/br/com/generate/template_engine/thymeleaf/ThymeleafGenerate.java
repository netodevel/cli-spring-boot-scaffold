package br.com.generate.template_engine.thymeleaf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import br.com.generate.GenerateTemplateEngine;

public class ThymeleafGenerate extends GenerateTemplateEngine {

	public ThymeleafGenerate(String className, String parameters) throws IOException {
		generateIndexHtml(className, parameters);
		generateFormHtml(className, parameters);
	}
	
	public void generateIndexHtml(String className, String parameters) throws IOException {
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-index.html"), null);
		String template = "layout";
		String classNameParam = className;
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String thAttributes = generateThParameters(parameters);
		String tdAttributes = generateTdParameters(className, parameters);
		String eachParam = className;
		
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
	
	public void generateShowHtml() {
	
	}
	
	public static void main(String[] args) throws IOException {
		new ThymeleafGenerate("User", "name:String email:String");
	}
	
	
}
