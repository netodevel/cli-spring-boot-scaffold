package br.com.generate.template_engine.thymeleaf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GenerateThymeleafFiles {

	public GenerateThymeleafFiles(String className, String parameters) throws IOException {
		generateIndexHTML(className, parameters);
	}
	
	public void generateIndexHTML(String className, String parameters) throws IOException {
		File htmlTemplateFile = new File("\templates\template-index.html");
		String htmlString = FileUtils.readFileToString(htmlTemplateFile);

		String template = "layout";
		String classNameParam = className;
		String paramClassName = className.toLowerCase();
		String path_url = "/" + className.toLowerCase() + "s";
		String th_attributes = generateThParameters(parameters);
		String td_attributes = generateTdParameters(className, parameters);
		String eachParam = className;
		
		htmlString = htmlString.replace("${template}", template);
		htmlString = htmlString.replace("${className}", classNameParam);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("eachParam", eachParam);
		htmlString = htmlString.replace("url_path", path_url);
		htmlString = htmlString.replace("${th_attributes}", th_attributes);
		htmlString = htmlString.replace("${td_attributes}", td_attributes);
		
		File newHtmlFile = new File("templates/" + className.toLowerCase() + "/index.html");
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
	}
	
	public String generateThParameters(String parameters) {
		String [] params = parameters.split(" ");
		String thParameters = "";
		
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			thParameters += "<th>" + nameAndType[0] + "</th> \n";
		}
		return thParameters;
	}
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = parameters.split(" ");
		String thParameters = "";
		
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			thParameters += "<td th:text=\"${" + className.toLowerCase() + "." + nameAndType[0] + "}\"></td> \n";
		}
		return thParameters;
	}

	public void generateShowHTML() {
	}

	public void generateFormHTML() {
	}
}
