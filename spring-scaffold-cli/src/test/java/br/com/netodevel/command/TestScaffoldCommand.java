package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.scaffold.ScaffoldCommand;
import br.com.netodevel.scaffold.ScaffoldHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestScaffoldCommand {

	@Test
	public void testRunScaffoldCommand() {
		try {
			new ScaffoldCommand("scaffold", "generate api scaffold kotlin", new ScaffoldHandler()).run("-n User", "-p name:String");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
