package br.com.netodevel.core.source;

/**
 * @author NetoDevel
 */
public class GeneratorOptions {

	private String nameModel;
	private String parameters;
	private String architecure;
	
	public String getNameModel() {
		return nameModel;
	}
	
	public GeneratorOptions setNameModel(String nameModel) {
		this.nameModel = nameModel;
		return this;
	}
	
	public String getParameters() {
		return parameters;
	}
	
	public GeneratorOptions setParameters(String parameters) {
		this.parameters = parameters;
		return this;
	}
	
	public String getArchitecure() {
		return architecure;
	}

	public GeneratorOptions setArchitecure(String architecure) {
		this.architecure = architecure;
		return this;
	}
	
}
