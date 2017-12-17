package br.com.netodevel.command.scaffold;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldCommand extends OptionParsingCommand{
	
	public ScaffoldCommand(String name, String description, OptionHandler handler) {
		super(name, description, handler);
	}

	@Override
	public String getUsageHelp() {
		return "-n \"NAME\" -p \"field:type field:type\"";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("scaffold", "scaffold -n User -p name:String"));
		return list;
	}
}
