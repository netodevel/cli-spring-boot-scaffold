package br.com.generate.java.command.model;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.GeneratorSource;
import br.com.generate.migrate.Migrations;
import br.com.util.ModelGenerateUtils;

/**
 * @author NetoDevel
 */
public class ModelGenerator extends GeneratorSource {
	
	@Override
	public String getLayer() {
		return Layers.MODEL;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".model")
				.replace("${imports}", ModelGenerateUtils.generateImports(parameters))
				.replace("${className}", nameClass)
				.replace("${name_table}", nameClass.toLowerCase() + "s")
				.replace("${parameters}", generateParams(parameters))
				.replace("${getters}", ModelGenerateUtils.generateGettersAndSetters(parameters));
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

	public static void main(String[] args) throws IOException  {
		new ModelGenerator().generate("User", "name:String mail:String age:Integer dataCreated:Date", "template-model.txt");
		Migrations migrations = new Migrations();
		try {
			migrations.create("User", "name:String mail:String age:Integer dataCreated:Date");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
