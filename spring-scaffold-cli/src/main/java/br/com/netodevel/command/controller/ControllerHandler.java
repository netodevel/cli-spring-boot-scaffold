package br.com.netodevel.command.controller;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.strategy.ControllerGenerateStrategy;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ControllerHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate controller").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		generateController(nameClass);
		return ExitStatus.OK;
	}

	private void generateController(String nameClass) {
		new ControllerGenerateStrategy(nameClass);
	}
	
}
