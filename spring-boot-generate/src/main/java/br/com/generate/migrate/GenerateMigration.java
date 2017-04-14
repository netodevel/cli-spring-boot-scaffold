package br.com.generate.migrate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GenerateMigration {

	/**
	 * create migration to generate model
	 * @param className
	 * @param parametersModel
	 * @throws Exception
	 */
	public static void createMigrationFromModel(String className, String parametersModel) throws Exception {
		String tableName = className;
		String textToGenerate = "CREATE TABLE " + tableName.toLowerCase() + " ( \n";
		String[] variablesSplits = parametersModel.split(" ");
		int i = 1;
		for (int z = 0; z < variablesSplits.length; z++) {
			String [] typeAndNameVars = variablesSplits[z].split(":");
			textToGenerate += "\t" + typeAndNameVars[0] + " " + convertTypeJavaToSQLType(typeAndNameVars[1]);
			textToGenerate = lastIndiceConcat(textToGenerate, i, variablesSplits);
			i++;
		}
		textToGenerate += ")";
		generateSQLFile(tableName, textToGenerate);
	}

	private static String lastIndiceConcat(String textToGenerate, int i, String[] variablesSplits) {
		if (i != variablesSplits.length) {
			textToGenerate += ", \n";
		} else {
			textToGenerate += "\n";
		}
		return textToGenerate;
	}
	
	/**
	 * Convert the type of attribute in java to type sql. 
	 * @param typeJava
	 * @return
	 * @throws Exception 
	 */
	public static String convertTypeJavaToSQLType(String typeJava) throws Exception {
		switch (typeJava) {
		case "String":
			return "character varying";
		case "Integer":
			return "int";
		case "Date":
			return "date";
		default:
			throw new Exception("type not implemented");
		}
	}

	public static void generateSQLFile(String tableName, String textToGenerate) {
		try {
			String fileName = "create_" + tableName + "_table.sql";
			File migrationFile = new File("src/main/resources/migrations/" + fileName);
			FileUtils.writeStringToFile(migrationFile, textToGenerate);
			System.out.println("migration created migrations/" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
