package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.setup.SetupScaffoldCommand;
import br.com.netodevel.command.setup.SetupScaffoldHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestSetupScaffoldCommand {

	@Test
	public void testRunControllerCommand() {
		try {
			new SetupScaffoldCommand("setup:scaffold", "setup scaffold", new SetupScaffoldHandler()).run("-d meubancodedados", "-u root", "-p root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
