package br.com.netodevel.command;

import br.com.generate.helpers.ScaffoldInfoHelper;
import br.com.netodevel.command.controller.ControllerCommand;
import br.com.netodevel.command.controller.ControllerHandler;
import br.com.netodevel.command.model.ModelCommand;
import br.com.netodevel.command.model.ModelHandler;
import br.com.netodevel.command.repository.RepositoryCommand;
import br.com.netodevel.command.repository.RepositoryHandler;
import br.com.netodevel.command.scaffold.ScaffoldCommand;
import br.com.netodevel.command.scaffold.ScaffoldHandler;
import br.com.netodevel.command.service.ServiceCommand;
import br.com.netodevel.command.service.ServiceHandler;
import br.com.netodevel.command.setup.SetupScaffoldCommand;
import br.com.netodevel.command.setup.SetupScaffoldHandler;
import br.com.netodevel.command.template.TemplateCommand;
import br.com.netodevel.command.template.TemplateHandler;
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
