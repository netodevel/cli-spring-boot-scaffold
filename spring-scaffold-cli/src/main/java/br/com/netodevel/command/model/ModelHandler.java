package br.com.netodevel.command.model;

import java.io.IOException;
import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.model.ModelGenerator;

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
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		generateModelJava(nameClass, parametersClass);
		return ExitStatus.OK;
	}
	
	private void generateModelJava(String nameClass, String parameters) throws IOException {
		new ModelGenerator().generate(nameClass, parameters, "template-model.txt");
	}
	
}
