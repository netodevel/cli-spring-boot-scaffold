package br.com.netodevel.command.repository;

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
public class RepositoryCommand extends OptionParsingCommand {

	public RepositoryCommand(String name, String description,OptionHandler handler) {
		super(name, description, handler);
	}
	
	@Override
	public String getUsageHelp() {
		return "[name-model]";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("create repository kotlin", "repository -n User -l kotlin"));
		list.add(new HelpExample("create repository java", "repository -n User -l java"));
		return list;
	}

}
