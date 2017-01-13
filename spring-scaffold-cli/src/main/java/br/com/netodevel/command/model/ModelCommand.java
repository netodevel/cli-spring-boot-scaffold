package br.com.netodevel.command.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

/**
 * command model for generate entitys
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelCommand extends OptionParsingCommand {

	public ModelCommand(String name, String description, OptionHandler handler) {
		super("model", "generate entities", new ModelHandler());
	}
	
	public String getUsageHelp() {
		// TODO Auto-generated method stub
		return "[name-entity] [attributes] [language]";
	}

	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("create entities java", "model -n User -p name:String"));
		list.add(new HelpExample("create entities kotlin", "model -n User -p name:String -l kotlin"));
		return list;
	}
	
}
