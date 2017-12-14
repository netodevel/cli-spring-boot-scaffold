package br.com.netodevel.generators.java.repository;

import br.com.netodevel.core.source.GeneratorOptions;
import br.com.netodevel.core.source.GeneratorSource;

public class GeneratorRepository extends GeneratorSource {

	public GeneratorRepository(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String layer() {
		return "repository";
	}

	public String packageName() {
		return "repository";
	}

	public String templateFile() {
		return "template-repository.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".repository")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${className}", generatorOptions.getNameModel());
	}

}
