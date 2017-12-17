package br.com.netodevel.core.view;

import java.io.IOException;

import br.com.netodevel.core.resources.AbstractGeneratorResource;

/**
 * @author NetoDevel
 */
public abstract class GeneratorView extends AbstractGeneratorResource {

	protected GeneratorViewOptions generatorViewOptions;
	private Object valueObject;
	
	public GeneratorView(GeneratorViewOptions generatorViewOptions) {
		this.generatorViewOptions = generatorViewOptions;
	}
	
	public GeneratorView(){
	}
	
	protected String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions) {
		return javaStrings;
	}
	
	protected String operationGenerate(String javaStrings) {
		return javaStrings;
	}
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFileResources(templateFile());
			String replaceStrings;
			if (this.generatorViewOptions != null) {
				replaceStrings = operationGenerate(javaStrings, this.generatorViewOptions);
			} else {
				replaceStrings = operationGenerate(javaStrings);
			}
			createNewResource(replaceStrings, resourceName);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public Object getValueObject() {
		return valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
}
