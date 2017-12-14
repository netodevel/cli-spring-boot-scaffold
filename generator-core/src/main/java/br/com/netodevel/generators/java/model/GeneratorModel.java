package br.com.netodevel.generators.java.model;

import br.com.netodevel.core.source.GeneratorOptions;
import br.com.netodevel.core.source.GeneratorSource;

/**
 * @author NetoDevel
 */
public class GeneratorModel extends GeneratorSource {

	public GeneratorModel(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String layer() {
		return "model";
	}

	public String packageName() {
		return "model";
	}

	public String templateFile() {
		return "template-model.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".model")
				.replace("${imports}", ModelGenerateUtils.generateImports(generatorOptions.getParameters()))
				.replace("${className}", generatorOptions.getNameModel())
				.replace("${name_table}", generatorOptions.getNameModel().toLowerCase() + "s")
				.replace("${parameters}", ModelGenerateUtils.generateParams(generatorOptions.getParameters()))
				.replace("${getters}", ModelGenerateUtils.generateGettersAndSetters(generatorOptions.getParameters()));
	}
	
	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setNameModel("User")
				.setParameters("name:String idade:Integer date:Date");
		
		
		new GeneratorModel(options).generate();		
	}

}
