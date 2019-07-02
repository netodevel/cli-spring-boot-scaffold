package br.com.generate.source.controller;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.helpers.FileHelper;

public class ControllerGenerator extends FileHelper {

	@Override
	public String getLayer() {
		return Layers.CONTROLLER;
	}

	@Override
	public String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_service}", getPackage() + ".service")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase())
				.replace("${url_path}", nameClass.toLowerCase() + "s");
	}
	
	public static void main(String[] args) throws IOException {
		new ControllerGenerator().generate("User", null, "template-controller.txt");
	}

}
