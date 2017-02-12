package br.com.generate.java.command.repository;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;

public class RepositoryGenerator extends ReadTemplateFile {

	@Override
	public String getLayer() {
		return Layers.REPOSITORY;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".repository")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${className}", nameClass);
	}

	
	public static void main(String[] args) throws IOException {
		new RepositoryGenerator().generate("User", null, "template-repository.txt");
	}
	
}
