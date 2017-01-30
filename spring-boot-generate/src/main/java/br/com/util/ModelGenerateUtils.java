package br.com.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * @author NetoDevel
 */
public class ModelGenerateUtils {
	
	private final static String TAB = "	";
	
	private String importVariable;
	
	private String nameVariable;
	
	public ModelGenerateUtils(String importVariable, String nameVariable) {
		super();
		this.setImportVariable(importVariable);
		this.setNameVariable(nameVariable);
	}
	
	public ModelGenerateUtils(){
	}
	
	public static List<ModelGenerateUtils> listGenerateImports() {
		return Arrays.asList(
				new ModelGenerateUtils("java.lang.String", "String"),
				new ModelGenerateUtils("java.lang.Integer", "Integer"),
				new ModelGenerateUtils("java.lang.Double", "Double"),
				new ModelGenerateUtils("java.lang.Float", "Float"),
				new ModelGenerateUtils("java.lang.Long", "Long"),
				new ModelGenerateUtils("java.lang.Short", "Short"),
				new ModelGenerateUtils("java.lang.Byte", "Byte"),
				new ModelGenerateUtils("java.lang.Char", "Char"),
				new ModelGenerateUtils("java.lang.Boolean", "Boolean"),
				new ModelGenerateUtils("java.lang.Object", "Object"),
				new ModelGenerateUtils("java.util.Date", "Date"),
				new ModelGenerateUtils("java.math.BigDecimal", "BigDecimal"));
	}
	
	public static String generateImports(String parameters) {
		String[] separator = parameters.split(" ");
		String imports = "";
		for (int i = 0; i < separator.length; i++) {
			String [] nameAndType = separator[i].split(":");

			for (int j = 0; j < listGenerateImports().size(); j++) {
				if (nameAndType[1].equals(listGenerateImports().get(j).getNameVariable())) {
					imports += "import " + listGenerateImports().get(j).getImportVariable() + "; \n";
				}
			}
			
		}
		return imports;
	}
	
	public static String generateGettersAndSetters(String parameters) {
		String[] separator = parameters.split(" ");
		String gettersAndSetters = "";
		for (int i = 0; i < separator.length; i++) {
			String [] nameAndType = separator[i].split(":");
			String name = nameAndType[0];
			String type = nameAndType[1];
			
			//SETTER
			gettersAndSetters += TAB + "public void set" + StringUtils.capitalize(name) + "(" + type + " " + name + ") {" ;
			gettersAndSetters += "this." + name + " = " + name + ";";
			gettersAndSetters += "}";
			
			gettersAndSetters += "\n";
			
			//GETTER
			gettersAndSetters += TAB + "public " + type + " get" + StringUtils.capitalize(name) + "() {" ;
			gettersAndSetters += "return " + name + ";";
			gettersAndSetters += "}";
			
			gettersAndSetters += "\n";
		}
		return gettersAndSetters;
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
