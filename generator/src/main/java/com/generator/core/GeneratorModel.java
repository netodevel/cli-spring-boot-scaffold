package com.generator.core;

import java.util.Map;

public class GeneratorModel {

	private String className;
	private Map<String, String> parameters;

	public GeneratorModel(){}

	public GeneratorModel(String className, Map<String, String> parameters) {
		this.className = className;
		this.parameters = parameters;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

}
