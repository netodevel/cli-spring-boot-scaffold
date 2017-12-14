package br.com.netodevel.core.view;

/**
 * @author NetoDevel
 */
public class GeneratorViewOptions {

	private String nameModel;
	private String parameters;
	private String layout;
	
	public String getNameModel() {
		return nameModel;
	}
	
	public GeneratorViewOptions setNameModel(String nameModel) {
		this.nameModel = nameModel;
		return this;
	}
	
	public String getParameters() {
		return parameters;
	}
	
	public GeneratorViewOptions setParameters(String parameters) {
		this.parameters = parameters;
		return this;
	}
	
	public String getLayout() {
		return layout;
	}

	public GeneratorViewOptions setLayout(String layout) {
		this.layout = layout;
		return this;
	}
	
}
