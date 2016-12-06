package br.com.netodevel.command.model;

import java.util.Arrays;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

/**
 * 
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelHandler extends OptionHandler {

	private OptionSpec<String> nameEntity;
	
	private OptionSpec<String> parametersEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate")
				.withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate")
				.withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		generateProject(nameClass, parametersClass);
		return ExitStatus.OK;
	}

	private void generateProject(String nameClass, String parameterClass) {
		System.out.println("generate model: " + nameClass + parameterClass);
	}
}
