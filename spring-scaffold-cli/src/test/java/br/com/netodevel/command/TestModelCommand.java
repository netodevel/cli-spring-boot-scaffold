package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.model.ModelCommand;
import br.com.netodevel.command.model.ModelHandler;

/**
 * 
 * @author NetoDevel
 * @since 0.0.1
 *
 */
public class TestModelCommand {
	
	@Test
	public void testRunModelCommand() {
		try {
			new ModelCommand("model", "generate entitys kotlin", new ModelHandler()).run("-n User", "-p name:String");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
