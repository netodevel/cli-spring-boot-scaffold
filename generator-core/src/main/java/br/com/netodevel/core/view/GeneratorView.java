package br.com.netodevel.core.view;

import java.io.IOException;

import br.com.netodevel.core.resources.AbstractGeneratorResource;

/**
 * @author NetoDevel
 */
public abstract class GeneratorView extends AbstractGeneratorResource {

	protected GeneratorViewOptions generatorViewOptions;
	
	public GeneratorView(GeneratorViewOptions generatorViewOptions) {
		this.generatorViewOptions = generatorViewOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions);
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFileResources(templateFile());
			String replaceStrings = operationGenerate(javaStrings, this.generatorViewOptions);
			
			createNewResource(replaceStrings, resourceName);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
