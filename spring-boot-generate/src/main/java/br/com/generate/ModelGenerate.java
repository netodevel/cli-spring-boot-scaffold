package br.com.generate;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ModelGenerate implements IGenerate {

	public boolean generate(String... params) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("model.kt", "UTF-8");
			imports(writer);
			writer.println("");
			writer.println("@Entity");
			writer.println("@Table(name = '" + params[0] + "')");
			writer.println("class " + params[0] + " (" + generateParams(params[1]) + ") {}");
			writer.close();
			System.out.println("model created!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		return true;
	}
	
	public void imports(PrintWriter print) {
		print.println("import javax.persistence.Entity");
		print.println("import javax.persistence.Table");
		print.println("import javax.persistence.Id");
		print.println("import javax.persistence.GenerationType");
		print.println("import javax.persistence.GeneratedValue");
	}
	
	public String generateParams(String params) {
		String totalText = "";
		String[] paramsSplit = params.split(" ");
		for (int i = 0; i < paramsSplit.length; i++) {
			if (paramsSplit[i].contains("String")) {
				totalText += " val " + paramsSplit[i];
			}
		}
		return totalText;
	}
}
