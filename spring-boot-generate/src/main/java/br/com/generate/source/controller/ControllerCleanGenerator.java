package br.com.generate.source.controller;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.helpers.FileHelper;

public class ControllerCleanGenerator extends FileHelper {

	@Override
	public String getLayer() {
		return Layers.CONTROLLER;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${path}", nameClass.toLowerCase())
				.replace("${className}", nameClass);
	}
	
	public static void main(String[] args) throws IOException {
		new ControllerCleanGenerator().generate("Credential", null, "template-clean-controller.txt");
	}
	
}
