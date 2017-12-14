package br.com.netodevel.core;

/**
 * @author NetoDevel
 */
public class GenerateModel {

	private String className;
	private String parameters;

	public GenerateModel() {
	}
	
	public GenerateModel(String className, String parameters) {
		super();
		this.className = className;
		this.parameters = parameters;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getParameters() {
		return parameters;
	}
	
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
}
