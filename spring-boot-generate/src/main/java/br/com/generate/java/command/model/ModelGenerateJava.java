package br.com.generate.java.command.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.AbstractModelGenerate;
import br.com.generate.IBaseScaffold;

/**
 * @author NetoDevel
 */
public class ModelGenerateJava implements IBaseScaffold {

	private AbstractModelGenerate abstractModelGenerate;
	
	public ModelGenerateJava(String nameClass, String parameters) {
		abstractModelGenerate = new AbstractModelGenerate();
		abstractModelGenerate.generate(nameClass, parameters);
		generate(nameClass, parameters);
	}
	
	@Override
	public void generate(String... params) {
		String CLASS_NAME = params[0];
		String PARAMS = params[1];
		
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/model/" + CLASS_NAME + ".java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				writer.println(""); 
				writer.println("@Entity"); //TODO: add lombok annotation.
				writer.println("@Table(name = \"" + CLASS_NAME.toLowerCase() + "s" + "\")");
				writer.println("public class " + CLASS_NAME + " extends AbstractModel<Long> {");
				writer.println("");
				writer.println("	private static final long serialVersionUID = 1L;");
				writer.println(generateParams(PARAMS));
				writer.println("}");
				writer.close();
				System.out.println("create src/main/java/br/com/scaffold/model/" + CLASS_NAME + ".java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold.model;");
		print.println("import javax.persistence.Entity;");
		print.println("import javax.persistence.Table;");
		print.println("import javax.persistence.Column;");
	}

	@Override
	public String generateParams(String params) {
		final int NAME_VARIABLE = 0;
		final int TYPE_VARIABLE = 1;
		
		String[] variablesSplits = params.split(" ");
		String[] typeAndNameVars = {""};
		
		String finalParameters = "";
		for (int i = 1; i < variablesSplits.length; i++) {

			typeAndNameVars = variablesSplits[i].split(":");
			
			String column = "    @Column(name = \"" + typeAndNameVars[NAME_VARIABLE] + "\")";
			String lineVariables = "    private " + typeAndNameVars[TYPE_VARIABLE] + " " + typeAndNameVars[NAME_VARIABLE] + ";";
			String lineClean = "\n";
			
			finalParameters += lineClean;
			finalParameters += column;
			finalParameters += lineClean;
			finalParameters += lineVariables;
			finalParameters += lineClean;
		}
		return finalParameters;
	}

	@Override
	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/model/" + nameFile + ".java");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}
	
	
}
