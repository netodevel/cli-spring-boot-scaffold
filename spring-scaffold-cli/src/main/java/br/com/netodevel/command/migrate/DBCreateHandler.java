package br.com.netodevel.command.migrate;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.migrate.CreateDatabase;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class DBCreateHandler extends OptionHandler {
	
	@SuppressWarnings("unused")
	private OptionSpec<String> typeDataBase;
	
	@Override
	protected void options() {
		this.typeDataBase = option(Arrays.asList("typeDatabase", "p"), "type of database to create").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String typeDatabase = (String) options.valueOf("p");
		CreateDatabase migrateDataBase = new CreateDatabase();
		migrateDataBase.createDatabase(typeDatabase.trim());
		return ExitStatus.OK;
	}
	
}
