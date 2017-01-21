package br.com.netodevel.scaffold;

import java.io.IOException;
import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.controller.ControllerGenerateJava;
import br.com.generate.java.command.model.ModelGenerateJava;
import br.com.generate.java.command.repository.RepositoryGenerateJava;
import br.com.generate.java.command.service.ServiceGenerateJava;
import br.com.generate.kotlin.command.ControllerGenerateKotlin;
import br.com.generate.kotlin.command.ModelGenerateKotlin;
import br.com.generate.kotlin.command.RepositoryGenerateKotlin;
import br.com.generate.kotlin.command.ServiceGenerateKotlin;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;

	@SuppressWarnings("unused")
	private OptionSpec<String> parametersEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
		this.language = option(Arrays.asList("language", "l"), "language generate java or kotlin").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		String language = (String) options.valueOf("l");
		if (language == null) {
			generateScaffoldJava(nameClass, parametersClass);
		} else if (language.equals(" java")) {
			generateScaffoldJava(nameClass, parametersClass);
		} else if (language.equals(" kotlin")) {
			generateScaffoldKotlin(nameClass, parametersClass);
		}
		return ExitStatus.OK;
	}

	private void generateScaffoldKotlin(String nameClass, String parametersClass) {
		new ModelGenerateKotlin(nameClass, parametersClass);
		new RepositoryGenerateKotlin(nameClass);
		new ServiceGenerateKotlin(nameClass);
		new ControllerGenerateKotlin(nameClass);
	}
	
	private void generateScaffoldJava(String nameClass, String parametersClass) throws IOException {
		new ModelGenerateJava(nameClass, parametersClass);
		new RepositoryGenerateJava(nameClass);
		new ServiceGenerateJava(nameClass);
		new ControllerGenerateJava(nameClass);
	}
	
}
