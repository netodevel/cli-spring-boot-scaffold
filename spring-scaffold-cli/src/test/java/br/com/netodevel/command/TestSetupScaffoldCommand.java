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
			new SetupScaffoldCommand("setupscaffold", "setup scaffold", new SetupScaffoldHandler()).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
