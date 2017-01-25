package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.controller.ControllerCommand;
import br.com.netodevel.command.controller.ControllerHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestControllerCommand {

	@Test
	public void testRunControllerCommand() {
		try {
			new ControllerCommand("controller", "generate controllers", new ControllerHandler()).run("-n User");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
