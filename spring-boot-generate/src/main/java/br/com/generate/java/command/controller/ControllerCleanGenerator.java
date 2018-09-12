package br.com.generate.java.command.controller;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.GeneratorSource;

public class ControllerCleanGenerator extends GeneratorSource {

	@Override
	public String getLayer() {
		return Layers.CONTROLLER;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${path}", nameClass.toLowerCase())
				.replace("${className}", nameClass);
	}
	
	public static void main(String[] args) throws IOException {
		new ControllerCleanGenerator().generate("Credential", null, "template-clean-controller.txt");
	}
	
}
