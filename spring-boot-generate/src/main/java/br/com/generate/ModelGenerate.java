package br.com.generate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ModelGenerate implements IGenerate {

	public void generate(String... params) {
		if (validateFile(params[0])) {
			PrintWriter writer = null;
			try {
				
				File file = new File("src/main/java/br/com/scaffold/model/" + params[0] + ".kt");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer);
				writer.println("");
				writer.println("@Entity");
				writer.println("@Table(name = '" + params[0] + "')");
				writer.println("class " + params[0] + " (" + generateParams(params[1]) + ") {}");
				writer.close();
				System.out.println("model created!");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}
	
	public void imports(PrintWriter print) {
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
