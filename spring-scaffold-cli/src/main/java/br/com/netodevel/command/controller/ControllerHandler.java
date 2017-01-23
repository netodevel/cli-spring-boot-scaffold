package br.com.netodevel.command.controller;

import java.io.IOException;
import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.controller.ControllerGenerateJava;
import br.com.generate.kotlin.command.ControllerGenerateKotlin;

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
			generateControllerJava(nameClass.trim());
		} else if (language.trim().equals("java")) {
			generateControllerJava(nameClass.trim());
		} else if (language.trim().equals("kotlin")) {
			generateControllerKotlin(nameClass.trim());
		}
		return ExitStatus.OK;
	}

	private void generateControllerKotlin(String nameClass) {
		new ControllerGenerateKotlin(nameClass);
	}
	
	private void generateControllerJava(String nameClass) throws IOException {
		new ControllerGenerateJava().generate(nameClass, "", "template-controller.txt");
	}
	
}
