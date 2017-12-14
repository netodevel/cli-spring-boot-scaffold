package br.com.netodevel.core.source;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorSource extends AbstractGenerator {
	
	private String javaStrings;
	private GeneratorOptions generateOptions;
	
	public GeneratorSource(GeneratorOptions generatorOptions) {
		this.generateOptions = generatorOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, GeneratorOptions generatorOptions);
	
	public GeneratorSource generate() {
		try {
			this.javaStrings = loadTemplateFile(templateFile()); 
			String replaceStrings = operationGenerate(this.javaStrings, this.generateOptions);
			createNewFile(replaceStrings, this.generateOptions.getNameModel());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

}
