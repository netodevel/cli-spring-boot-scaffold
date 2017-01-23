package br.com.generate;

import java.util.Arrays;
import java.util.List;

/**
 * @author NetoDevel
 */
public class GenerateImports {
	
	private String importVariable;
	
	private String nameVariable;
	
	public GenerateImports(String importVariable, String nameVariable) {
		super();
		this.setImportVariable(importVariable);
		this.setNameVariable(nameVariable);
	}
	
	public GenerateImports(){
	}
	
	public static List<GenerateImports> listGenerateImports() {
		return Arrays.asList(
				new GenerateImports("java.lang.String", "String"),
				new GenerateImports("java.lang.Integer", "Integer"),
				new GenerateImports("java.lang.Double", "Double"),
				new GenerateImports("java.lang.Float", "Float"),
				new GenerateImports("java.lang.Long", "Long"),
				new GenerateImports("java.lang.Short", "Short"),
				new GenerateImports("java.lang.Byte", "Byte"),
				new GenerateImports("java.lang.Char", "Char"),
				new GenerateImports("java.lang.Boolean", "Boolean"),
				new GenerateImports("java.lang.Object", "Object"),
				new GenerateImports("java.math.BigDecimal", "BigDecimal"));
	}
	
	public static String generateImports(String parameters) {
		String[] separator = parameters.split(" ");
		String imports = "";
		for (int i = 0; i < separator.length; i++) {
			String [] nameAndType = separator[i].split(":");

			for (int j = 0; j < listGenerateImports().size(); j++) {
				if (nameAndType[1].equals(listGenerateImports().get(j).getNameVariable())) {
					imports += listGenerateImports().get(j).getImportVariable() + "\n";
				}
			}
			
		}
		return imports;
	}

	public String getNameVariable() {
		return nameVariable;
	}

	public void setNameVariable(String nameVariable) {
		this.nameVariable = nameVariable;
	}

	public String getImportVariable() {
		return importVariable;
	}

	public void setImportVariable(String importVariable) {
		this.importVariable = importVariable;
	}
	
}
