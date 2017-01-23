package br.com.generate.java.command.model;

import br.com.generate.ReadTemplateFile;

/**
 * @author NetoDevel
 */
public class ModelGenerateJava extends ReadTemplateFile {
	
	@Override
	public String getLayer() {
		return "model";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".model")
				.replace("${className}", nameClass)
				.replace("${name_table}", nameClass.toLowerCase() + "s")
				.replace("${parameters}", generateParams(parameters));
	}
	
	public String generateParams(String params) {
		String[] variablesSplits = params.split(" ");
		String finalParameters = "";
		for (int i = 0; i < variablesSplits.length; i++) {

			String [] typeAndNameVars = variablesSplits[i].split(":");

			String column = "    @Column(name = \"" + typeAndNameVars[0] + "\")";
			String lineVariables = "    private " + typeAndNameVars[1] + " " + typeAndNameVars[0] + ";";
			String lineClean = "\n";

			finalParameters += lineClean;
			finalParameters += column;
			finalParameters += lineClean;
			finalParameters += lineVariables;
			finalParameters += lineClean;
		}
		return finalParameters;
	}

}
