package br.com.generate.kotlin.command;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.AbstractModelGenerate;
import br.com.generate.IBaseScaffold;

/**
 * Provider the generate of a model/entity
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelGenerateKotlin implements IBaseScaffold {

	private AbstractModelGenerate abstractModelGenerate;
	
	public ModelGenerateKotlin(String nameClass, String parameter) {
		abstractModelGenerate = new AbstractModelGenerate();
		abstractModelGenerate.generate(nameClass, parameter);
		generate(nameClass, parameter);
	}

	public void generate(String... params) {
		String CLASS_NAME = params[0];
		String PARAMS = params[1];
		
		if (validateFile(CLASS_NAME)) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/model/" + CLASS_NAME + ".kt");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				writer.println("");
				writer.println("@Entity");
				writer.println("@Table(name = \"" + CLASS_NAME.toLowerCase() + "s" + "\")");
				writer.println("class " + CLASS_NAME + " (@Id val id:Long, " + generateParams(PARAMS) + ") : AbstractModel<Long>() {}");
				writer.close();
				System.out.println("invoke spring data-jpa");
				System.out.println("create src/main/java/br/com/scaffold/model/" + CLASS_NAME + ".kt");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}
	
	public void imports(PrintWriter print, String[] namesParams) {
		print.println("package br.com.scaffold.model");
		print.println("import javax.persistence.Entity");
		print.println("import javax.persistence.Table");
		print.println("import javax.persistence.Id");
		print.println("import javax.persistence.GenerationType");
		print.println("import javax.persistence.GeneratedValue");
	}
	
	public String generateParams(String params) {
		String totalText = "";
		String[] paramsSplit = params.split(" ");
		for (int i = 1; i < paramsSplit.length; i++) {
			if (i == 1 && paramsSplit.length > 2) {
				totalText += "val " + paramsSplit[i] + ", ";
			} else if (i == 1 && paramsSplit.length == 1) {
				totalText += "val " + paramsSplit[i];
			} else if (i + 1 == paramsSplit.length) {
				totalText += "val " + paramsSplit[i];
			} else {
				totalText += "val " + paramsSplit[i] + ", ";
			}
		}
		return totalText;
	}

	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/model/" + nameFile + ".kt");
		if(f.exists()) { 
			System.out.println("File already exists!");
			return false;
		} else {
			return true;
		}
	}
	
}
