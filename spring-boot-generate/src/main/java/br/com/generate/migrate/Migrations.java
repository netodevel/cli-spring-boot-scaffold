package br.com.generate.migrate;

/**
 * Generate migrations
 * @author neto
 */
public class Migrations {
	
	public void create(String className, String parametersModel) throws Exception {
		GenerateMigration.createMigrationFromModel(className, parametersModel);
	}
}
