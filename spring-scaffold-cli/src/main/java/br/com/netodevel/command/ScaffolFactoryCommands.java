package br.com.netodevel.command;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

import br.com.netodevel.command.controller.ControllerCommand;
import br.com.netodevel.command.controller.ControllerHandler;
import br.com.netodevel.command.model.ModelCommand;
import br.com.netodevel.command.model.ModelHandler;
import br.com.netodevel.command.repository.RepositoryCommand;
import br.com.netodevel.command.repository.RepositoryHandler;
import br.com.netodevel.command.service.ServiceCommand;
import br.com.netodevel.command.service.ServiceHandler;
import br.com.netodevel.scaffold.ScaffoldCommand;
import br.com.netodevel.scaffold.ScaffoldHandler;

/**
 * all commands scaffold
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffolFactoryCommands implements CommandFactory {

	public Collection<Command> getCommands() {
		return Arrays.<Command>asList(
			new ModelCommand("model", "generate entities kotlin", new ModelHandler()),
			new RepositoryCommand("repository", "generate repositories kotlin", new RepositoryHandler()),
			new ServiceCommand("service", "generate services kotlin", new ServiceHandler()),
			new ControllerCommand("controller", "generate controllers kotlin", new ControllerHandler()),
			new ScaffoldCommand("scaffold", "generate api scaffold kotlin", new ScaffoldHandler()));
	}

}
