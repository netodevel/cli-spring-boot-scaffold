package br.com.netodevel.command.repository;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.RepositoryGenerateJava;
import br.com.generate.kotlin.command.RepositoryGenerateKotlin;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class RepositoryHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate repository").withRequiredArg();
		this.language = option(Arrays.asList("language", "l"), "language generate java or kotlin").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String language = (String) options.valueOf("l");
		if (language == null) {
			generateRepositoryJava(nameClass);
		} else if (language.equals(" java")) {
			generateRepositoryJava(nameClass);
		} else if (language.equals(" kotlin")) {
			generateRepositoryKotlin(nameClass);
		}
		return ExitStatus.OK;
	}

	private void generateRepositoryKotlin(String nameClass) {
		new RepositoryGenerateKotlin(nameClass);
	}
	
	private void generateRepositoryJava(String nameClass) {
		new RepositoryGenerateJava(nameClass);
	}
}
