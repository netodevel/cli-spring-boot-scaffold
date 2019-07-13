package br.com.command;

import br.com.command.model.ModelHandler;
import br.com.generate.helpers.ScaffoldInfoHelper;
import br.com.command.controller.ControllerCommand;
import br.com.command.controller.ControllerHandler;
import br.com.command.model.ModelCommand;
import br.com.command.repository.RepositoryCommand;
import br.com.command.repository.RepositoryHandler;
import br.com.command.scaffold.ScaffoldCommand;
import br.com.command.scaffold.ScaffoldHandler;
import br.com.command.service.ServiceCommand;
import br.com.command.service.ServiceHandler;
import br.com.command.setup.SetupScaffoldCommand;
import br.com.command.setup.SetupScaffoldHandler;
import br.com.command.template.TemplateCommand;
import br.com.command.template.TemplateHandler;
import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * all commands scaffold
 *
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldFactoryCommands implements CommandFactory {

    public Collection<Command> getCommands() {
        return Arrays.<Command>asList(
                new ModelCommand("model", "generate entities", new ModelHandler()),
                new RepositoryCommand("repository", "generate repositories", new RepositoryHandler()),
                new ServiceCommand("service", "generate services", new ServiceHandler()),
                new ControllerCommand("controller", "generate controllers", new ControllerHandler()),
                new ScaffoldCommand("scaffold", "generate api scaffold", new ScaffoldHandler()),
                new SetupScaffoldCommand("setup:scaffold", "setup scaffold", new SetupScaffoldHandler()),
                new TemplateCommand("template", "generate setup project", new TemplateHandler(new ScaffoldInfoHelper())));
    }

}
