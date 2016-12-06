package br.com.netodevel.command;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

import br.com.netodevel.command.model.ModelCommand;
import br.com.netodevel.command.model.ModelHandler;

/**
 * all commands scaffold
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffolFactoryCommands implements CommandFactory {

	public Collection<Command> getCommands() {
		return Arrays.<Command>asList(new ModelCommand("model", "generate entitys kotlin", new ModelHandler()));
	}

}
