package br.com.generate.java.command.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import br.com.generate.ReadScaffoldInfo;

public class ControllerCleanGenerateJava extends ReadScaffoldInfo {
	
	public ControllerCleanGenerateJava(String className) throws IOException {
		generate(className);
	}	
	
	public void generate(String className) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/controller/template-clean-controller.txt");
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);
		
		javaStrings = javaStrings.replace("${package}", getPackage() + ".controller");
		javaStrings = javaStrings.replace("${className}", className);
		
		File newJavaFile = new File(getPathPackage() + "controller/" + className + "Controller.java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage() + className + "Controller.java");
	}
	
}
