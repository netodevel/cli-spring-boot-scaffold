package br.com.netodevel.command.repository;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.strategy.RepositoryGenerateStrategy;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class RepositoryHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate repository").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		generateRepository(nameClass);
		return ExitStatus.OK;
	}

	private void generateRepository(String nameClass) {
		new RepositoryGenerateStrategy(nameClass);
	}
}
