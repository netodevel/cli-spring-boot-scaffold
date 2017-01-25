package br.com.generate.java.command.service;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;

public class ServiceGenerateJava extends ReadTemplateFile {

	@Override
	public String getLayer() {
		return Layers.SERVICE;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());

	}

	public static void main(String[] args) throws IOException {
		new ServiceGenerateJava().generate("User", null, "template-service.txt");
	}
	
}

