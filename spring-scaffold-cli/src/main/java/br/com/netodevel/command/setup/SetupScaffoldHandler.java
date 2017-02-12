package br.com.netodevel.command.setup;

import java.util.Arrays;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.application.properties.ApplicationPropertiesGenerator;
import br.com.generate.setup.command.SetupGenerator;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class SetupScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> namePackage;

	@SuppressWarnings("unused")
	private OptionSpec<String> dataBase;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> userDatabase;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> passwordDatabase;
	
	@Override
	protected void options() {
		this.namePackage = option(Arrays.asList("namePackage", "n"), "name of package to create scaffolds").withOptionalArg();
		this.dataBase = option(Arrays.asList("dataBaseName", "d"), "name of database").withOptionalArg();
		this.userDatabase = option(Arrays.asList("userDatabase", "u"), "username database for migrates").withOptionalArg();
		this.passwordDatabase = option(Arrays.asList("passwordDatabase", "p"), "password database for migrates").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String namePackage = (String) options.valueOf("n");
		String nameDataBase = (String) options.valueOf("d");
		String userNameDatabase = (String) options.valueOf("u");
		String passwordDatabase = (String) options.valueOf("p");
		
		namePackage = namePackage != null ? namePackage.trim() : namePackage;
		nameDataBase = nameDataBase != null ? nameDataBase.trim() : nameDataBase;
		userNameDatabase = userNameDatabase != null ? userNameDatabase.trim() : userNameDatabase;
		passwordDatabase = passwordDatabase != null ? passwordDatabase.trim() : passwordDatabase;
		
		new SetupGenerator(namePackage, nameDataBase, userNameDatabase, passwordDatabase);
		new ApplicationPropertiesGenerator();
		
		return ExitStatus.OK;
	}
	
}
