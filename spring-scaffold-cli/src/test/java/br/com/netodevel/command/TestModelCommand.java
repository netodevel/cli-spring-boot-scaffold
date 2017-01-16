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
	public void testRunModelCommandKotlin() {
		try {
			new ModelCommand("model", "generate entitys", new ModelHandler()).run("-n UserModel", "-p name:String", "-l java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
