package br.com.netodevel.command;

import org.junit.Test;

import br.com.netodevel.command.migrate.DBCreateCommand;
import br.com.netodevel.command.migrate.DBCreateHandler;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class TestDBCreateCommand {

	@Test
	public void testRunControllerCommand() {
		try {
			new DBCreateCommand("db:create", "create database", new DBCreateHandler()).run("-p mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
