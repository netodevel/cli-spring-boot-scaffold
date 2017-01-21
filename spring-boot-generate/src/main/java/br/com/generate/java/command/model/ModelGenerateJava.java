package br.com.generate.java.command.model;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import br.com.generate.ReadScaffoldInfo;

/**
 * @author NetoDevel
 */
public class ModelGenerateJava extends ReadScaffoldInfo {

	public ModelGenerateJava(String nameClass, String parameters) throws IOException {
		generate(nameClass, parameters);
	}
	
	public void generate(String className, String parameters) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/model/template-model.txt");
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);
		javaStrings = javaStrings.replace("${package}", getPackage() + ".model");
		javaStrings = javaStrings.replace("${className}", className);
		javaStrings = javaStrings.replace("${name_table}", className.toLowerCase() + "s");
		javaStrings = javaStrings.replace("${parameters}", generateParams(parameters));
		
		File newJavaFile = new File(getPathPackage() + "model/" + className + ".java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage() + "model/" + className + ".java");
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
