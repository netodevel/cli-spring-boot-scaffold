package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.scaffold.ScaffoldCommand;
import br.com.netodevel.command.scaffold.ScaffoldHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestScaffoldCommand {

	@Test
	public void testRunScaffoldCommand() {
		try {
			new ScaffoldCommand("scaffold", "generate scaffold", new ScaffoldHandler()).run("-nUser", "-pname:String email:String idade:Integer dateCreated:Date admin:Boolean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
