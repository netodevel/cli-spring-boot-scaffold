package br.com.netodevel.command.service;

import java.io.IOException;
import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.service.ServiceGenerateJava;
import br.com.generate.kotlin.command.ServiceGenerateKotlin;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ServiceHandler extends OptionHandler {
	
	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate service").withRequiredArg();
		this.language = option(Arrays.asList("language", "l"), "language generate java or kotlin").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String language = (String) options.valueOf("l");
		if (language == null) {
			generateServiceJava(nameClass.trim());
		} else if (language.trim().equals("java")) {
			generateServiceJava(nameClass.trim());
		} else if (language.trim().equals("kotlin")) {
			generateServiceKotlin(nameClass.trim());
		}
		return ExitStatus.OK;
	}

	private void generateServiceKotlin(String nameClass) {
		new ServiceGenerateKotlin(nameClass);
	}
	
	private void generateServiceJava(String nameClass) throws IOException {
		new ServiceGenerateJava().generate(nameClass, null, "template-service.txt");
	}
	
	
}
