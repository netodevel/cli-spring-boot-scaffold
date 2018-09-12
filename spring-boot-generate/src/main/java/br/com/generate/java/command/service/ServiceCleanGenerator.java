package br.com.generate.java.command.service;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.GeneratorSource;

public class ServiceCleanGenerator extends GeneratorSource {

	@Override
	public String getLayer() {
		return Layers.SERVICE;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${className}", nameClass);
	}

	public static void main(String[] args) throws IOException {
		new ServiceCleanGenerator().generate("User", null, "template-clean-service.txt");
	}
	
}

