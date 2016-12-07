package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.service.ServiceCommand;
import br.com.netodevel.command.service.ServiceHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestServiceCommand {
	
	@Test
	public void testRunServiceCommand() {
		try {
			new ServiceCommand("service", "generate services kotlin", new ServiceHandler()).run("-n User");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
