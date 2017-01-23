package br.com.generate.java.command.service;

import br.com.generate.ReadTemplateFile;

public class ServiceGenerateJava extends ReadTemplateFile {

	@Override
	public String getLayer() {
		return "service";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());

	}

}

