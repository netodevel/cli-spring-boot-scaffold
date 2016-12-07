package br.com.netodevel.command.service;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.strategy.ServiceGenerateStrategy;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ServiceHandler extends OptionHandler {
	
	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate service").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		generateService(nameClass);
		return ExitStatus.OK;
	}

	private void generateService(String nameClass) {
		new ServiceGenerateStrategy(nameClass);
	}
}
