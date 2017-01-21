package br.com.generate.java.command.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import br.com.generate.ReadScaffoldInfo;

public class ServiceGenerateJava extends ReadScaffoldInfo {

	public ServiceGenerateJava(String className) throws IOException {
		generate(className);
	}
	
	public void generate(String className) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/service/template-service.txt");
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);

		javaStrings = javaStrings.replace("${package}", getPackage() + ".service");
		javaStrings = javaStrings.replace("${package_model}", getPackage() + ".model");
		javaStrings = javaStrings.replace("${package_repository}", getPackage() + ".repository");
		javaStrings = javaStrings.replace("${className}", className);
		javaStrings = javaStrings.replace("${paramClassName}", className.toLowerCase());

		File newJavaFile = new File(getPathPackage() + "service/" + className + "Service.java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage() + className + "Service.java");
	}
	
	public static void main(String[] args) throws IOException {
		new ServiceGenerateJava("User");
	}
	
}
	
