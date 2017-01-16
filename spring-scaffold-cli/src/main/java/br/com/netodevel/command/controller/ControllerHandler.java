package br.com.netodevel.command.controller;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.ControllerGenerateJava;
import br.com.generate.kotlin.ControllerGenerateKotlin;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ControllerHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate controller").withRequiredArg();
		this.language = option(Arrays.asList("language", "l"), "language generate java or kotlin").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String language = (String) options.valueOf("l");
		if (language == null) {
			generateControllerJava(nameClass);
		} else if (language.equals(" java")) {
			generateControllerJava(nameClass);
		} else if (language.equals(" kotlin")) {
			generateControllerKotlin(nameClass);
		}
		return ExitStatus.OK;
	}

	private void generateControllerKotlin(String nameClass) {
		new ControllerGenerateKotlin(nameClass);
	}
	
	private void generateControllerJava(String nameClass) {
		new ControllerGenerateJava(nameClass);
	}
	
}
