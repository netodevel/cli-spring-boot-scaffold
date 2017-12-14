package br.com.netodevel.generators.resources;

import br.com.netodevel.core.resources.GeneratorResource;
import br.com.netodevel.core.resources.GeneratorResourceOptions;

/**
 * @author NetoDevel
 */
public class GeneratorScaffoldInfo extends GeneratorResource {

	public static final String DEFAULT_ORM = "jpa";
	public static final String DEFAULT_USER_DATABASE = "root";
	public static final String DEFAULT_PASSWORD_DATABASE = "";

	public GeneratorScaffoldInfo(GeneratorResourceOptions generatorOptions) {
		super(generatorOptions);
	}

	public String folder() {
		return ROOT;
	}

	public String layer() {
		return "scaffold";
	}

	public String templateFile() {
		return "template-scaffold-info.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorResourceOptions generatorOptions) {
		return javaStrings.replace("${package}", generatorOptions.getPackageName() != null ? generatorOptions.getPackageName() : "com.example")
				.replace("${database_name}", generatorOptions.getDatabase() != null ? generatorOptions.getDatabase() : "mysql")
				.replace("${user_database}", generatorOptions.getUserDatabase(DEFAULT_USER_DATABASE))
				.replace("${orm}", generatorOptions.getOrm(DEFAULT_ORM))
				.replace("${password_database}", generatorOptions.getPasswordDatabase(DEFAULT_PASSWORD_DATABASE));
	}
	
	public static void main(String[] args) {
		GeneratorResourceOptions options = new GeneratorResourceOptions()
				.setDatabase("mysql")
				.setPackageName("br.com.netodevel")
				.setUserDatabase("root")
				.setPasswordDatabase("netinho123");
		
		new GeneratorScaffoldInfo(options).generate("scaffold.info");
	}

}
