package br.com.netodevel.command.migrate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

public class DBCreateCommand extends OptionParsingCommand {

	public DBCreateCommand(String name, String description, OptionHandler handler) {
		super(name, description, handler);
	}

	@Override
	public String getUsageHelp() {
		return "[namedatabase][typedatabase]";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("create database mysql", "spring db:create -n mydatabase -p mysql"));
		list.add(new HelpExample("create database postgresql", "spring db:create -n mydatabase -p postgresql"));
		return list;
	}
	
}
