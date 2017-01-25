package br.com.netodevel.command.model;

import java.io.IOException;
import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.model.ModelGenerateJava;
import br.com.generate.kotlin.command.ModelGenerateKotlin;

/**
 * 
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> parametersEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate")
				.withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate")
				.withRequiredArg();
		
		this.language = option(Arrays.asList("language", "l"), "language generate java or kotlin")
				.withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		String language = (String) options.valueOf("l");
		
		if (language == null) {
			generateJava(nameClass.trim(), parametersClass);
		} else if (language.trim().equals("java")) {
			generateJava(nameClass.trim(), parametersClass);
		} else if (language.trim().equals("kotlin")) {
			generateModelKotlin(nameClass.trim(), parametersClass);
		}
		
		return ExitStatus.OK;
	}
	
	private void generateJava(String nameClass, String parametersClass) throws IOException {
		generateModelJava(nameClass, parametersClass);
	}

	private void generateModelKotlin(String nameClass, String parameterClass) {
		new ModelGenerateKotlin(nameClass, parameterClass);
	}
	
	private void generateModelJava(String nameClass, String parameters) throws IOException {
		new ModelGenerateJava().generate(nameClass, parameters, "template-model.txt");
	}
}
