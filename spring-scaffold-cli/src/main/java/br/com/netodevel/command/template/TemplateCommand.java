package br.com.netodevel.command.template;

import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

public class TemplateCommand extends OptionParsingCommand {

    public TemplateCommand(String name, String description, OptionHandler handler) {
        super(name, description, handler);
    }

    @Override
    public String getUsageHelp() {
        return "[options] <template>";
    }

}
