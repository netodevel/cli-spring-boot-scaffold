package br.com.netodevel.core.source;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorSource extends AbstractGenerator {
	
	private String javaStrings;
	private GeneratorOptions generateOptions;
	private Object valueObject;
	
	public GeneratorSource(){
	}
	
	public GeneratorSource(GeneratorOptions generatorOptions) {
		this.generateOptions = generatorOptions;
	}
	
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions){
		return javaStrings;
	}
	
	protected String operationGenerate(String javaStrings) {
		return javaStrings;
	}
	
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
	
	public GeneratorSource generate(String fileName) {
		try {
			this.javaStrings = loadTemplateFile(templateFile()); 
			String replaceStrings = operationGenerate(this.javaStrings);
			createNewFile(replaceStrings, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public Object getObject() {
		return valueObject;
	}

	public void setValueObject(Object object) {
		this.valueObject = object;
	}

}
