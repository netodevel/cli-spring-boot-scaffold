package br.com.netodevel.command.setup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

public class SetupScaffoldCommand extends OptionParsingCommand {

	public SetupScaffoldCommand(String name, String description, OptionHandler handler) {
		super(name, description, handler);
	}

	@Override
	public String getUsageHelp() {
		return "[namepackage][user-database][password-database]";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("setup scaffold", "spring setup:scaffold"));
		list.add(new HelpExample("setup scaffold with parameters", "spring setup:scaffold -p com.example -u root -p root"));
		return list;
	}
	
}
