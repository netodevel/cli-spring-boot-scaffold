package br.com.netodevel.core.resources;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorResource extends AbstractGeneratorResource implements GeneratorResourceBase {
	
	public static final String ROOT = "";
	protected GeneratorResourceOptions generatorOptions;
	private Object valueObject;
	
	public GeneratorResource() {
	}
	
	public GeneratorResource(GeneratorResourceOptions generatorOptions) {
		this.generatorOptions = generatorOptions;
	}
	
	protected String operationGenerate(String javaStrings, GeneratorResourceOptions generateOptions){
		return javaStrings;
	}
	
	protected String operationGenerate(String javaStrings) {
		return javaStrings;
	}
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFileResources(templateFile());
			String replaceStrings;
			if (this.generatorOptions != null) {
				replaceStrings = operationGenerate(javaStrings, this.generatorOptions);
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
