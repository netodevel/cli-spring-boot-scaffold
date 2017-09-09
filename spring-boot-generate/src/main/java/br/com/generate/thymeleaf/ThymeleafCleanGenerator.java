package br.com.generate.thymeleaf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ThymeleafCleanGenerator extends AbstractThymeleafGenerate {

	public void index(String className, String parameters) throws IOException {
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-clean-index.html"), null);
		String template = "layout";
		String classNameParam = className;
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String eachParam = "list" + className;
		
		htmlString = htmlString.replace("${template}", template);
		htmlString = htmlString.replace("${className}", classNameParam);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("eachParam", eachParam);
		htmlString = htmlString.replace("url_path", pathUrl);
		
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/" + className.toLowerCase() + "/index.html");
		
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/" + className.toLowerCase() + "/index.html");
	}
	
}
