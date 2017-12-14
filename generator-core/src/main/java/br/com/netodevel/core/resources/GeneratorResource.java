package br.com.netodevel.core.resources;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorResource extends AbstractGeneratorResource implements GeneratorResourceBase {
	
	public static final String ROOT = "";
	protected GeneratorResourceOptions generatorOptions;
	
	public GeneratorResource() {
	}
	
	public GeneratorResource(GeneratorResourceOptions generatorOptions) {
		this.generatorOptions = generatorOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, GeneratorResourceOptions generateOptions);
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFileResources(templateFile());
			String replaceStrings = operationGenerate(javaStrings, this.generatorOptions);
			
			createNewResource(replaceStrings, resourceName);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
