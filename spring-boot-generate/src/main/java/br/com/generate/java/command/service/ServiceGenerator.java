package br.com.generate.java.command.service;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;
import br.com.generate.ReadScaffoldInfo;

public class ServiceGenerator extends ReadTemplateFile {
	
	String springVersion = getSpringVersion();

	@Override
	public String getLayer() {
		return Layers.SERVICE;
	}
	
	public function 

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		if (this.springVersion == '2.x') {
			javaStrings.replace('.findOne(id)', '.findById(id).get()');
		}
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());

	}

	public static void main(String[] args) throws IOException {
		new ServiceGenerator().generate("User", null, "template-service.txt");
	}
	
}

