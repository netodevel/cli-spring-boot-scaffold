package br.com.netodevel.generators.resources;

import java.io.IOException;

import br.com.netodevel.core.resources.GeneratorResource;
import br.com.netodevel.core.resources.GeneratorResourceOptions;

public class GeneratorApplicationProperties extends GeneratorResource {

	public GeneratorApplicationProperties(GeneratorResourceOptions generatorOptions) {
		super(generatorOptions);
	}

	public String folder() {
		return ROOT;
	}

	public String layer() {
		return "spring";
	}

	public String templateFile() {
		return "template-application-props.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorResourceOptions generatorOptions) {
		
		/**
		 * TODO: factory to all orms supported
		 */
		if(generatorOptions.getOrm().equals("jpa")) {
			javaStrings = javaStrings.replace("${jpa_config}", ConfigProps.JPA_CONFIG);
		}
		
		/**
		 * TODO: factory to all server supported
		 */
		if (generatorOptions.getServer().equals("tomcat")) {
			javaStrings = javaStrings.replace("${server_config}", ConfigProps.TOMCAT_CONFIG);
		}
		
		try {
			javaStrings = javaStrings.replace("${database_name}", getNameDatabase())
					.replace("${database}", generatorOptions.getDatabase())
					.replace("${user_database}", generatorOptions.getUserDatabase(GeneratorScaffoldInfo.DEFAULT_USER_DATABASE))
					.replace("${password_database}", generatorOptions.getPasswordDatabase(GeneratorScaffoldInfo.DEFAULT_PASSWORD_DATABASE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return javaStrings;
	}
	
	public static void main(String[] args) {
		GeneratorResourceOptions options = new GeneratorResourceOptions()
				.setDatabase("mysql")
				.setOrm("jpa")
				.setServer("tomcat");
		
		new GeneratorApplicationProperties(options).generate("application.properties");
	}
	
}
