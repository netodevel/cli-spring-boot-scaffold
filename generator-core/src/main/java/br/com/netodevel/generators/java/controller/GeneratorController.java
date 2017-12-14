package br.com.netodevel.generators.java.controller;

import br.com.netodevel.core.source.GeneratorOptions;
import br.com.netodevel.core.source.GeneratorSource;

public class GeneratorController extends GeneratorSource {

	public GeneratorController(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String layer() {
		return "controller";
	}

	public String packageName() {
		return "controller";
	}

	public String templateFile() {
		return "template-controller.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_service}", getPackage() + ".service")
				.replace("${className}", generatorOptions.getNameModel())
				.replace("${paramClassName}", generatorOptions.getNameModel().toLowerCase())
				.replace("${url_path}", generatorOptions.getNameModel().toLowerCase() + "s");
	}

	
	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setNameModel("User")
				.setParameters("name:String email:String");
		
		new GeneratorController(options).generate();
	}
		
}
