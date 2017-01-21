package br.com.generate.java.command.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import br.com.generate.ReadScaffoldInfo;

public class ControllerGenerateJava extends ReadScaffoldInfo {

	public ControllerGenerateJava(String className) throws IOException {
		generate(className);
	}

	public void generate(String className) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/controller/template-controller.txt");
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);

		javaStrings = javaStrings.replace("${package}", getPackage() + ".controller");
		javaStrings = javaStrings.replace("${package_model}", getPackage() + ".model");
		javaStrings = javaStrings.replace("${package_service}", getPackage() + ".service");
		javaStrings = javaStrings.replace("${className}", className);
		javaStrings = javaStrings.replace("${paramClassName}", className.toLowerCase());
		javaStrings = javaStrings.replace("${url_path}", className.toLowerCase() + "s");

		File newJavaFile = new File(getPathPackage() + "controller/" + className + "Controller.java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage()  + "controller/" + className + "Controller.java");
	}
	
	public static void main(String[] args) throws IOException {
		new ControllerGenerateJava("User");
	}

}
