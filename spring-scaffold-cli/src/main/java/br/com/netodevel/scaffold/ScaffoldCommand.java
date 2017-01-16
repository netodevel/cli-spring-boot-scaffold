package br.com.netodevel.scaffold;

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
		return "[name-model] [parameters-model]";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("create scaffold api kotlin", "scaffold -n User -p name:String -l kotlin"));
		list.add(new HelpExample("create scaffold api java", "scaffold -n User -p name:String -l java"));
		return list;
	}
}
