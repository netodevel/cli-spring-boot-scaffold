package br.com.command.model;

import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

/**
 * command model for generate entitys
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelCommand extends OptionParsingCommand {

	public ModelCommand(String name, String description, OptionHandler handler) {
		super(name, description, handler);
	}

	@Override
	public String getUsageHelp() {
		return "<entity> <attributes>";
	}
}
