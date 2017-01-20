package br.com.generate.java.command.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

public class AbstractModelGenerate implements IBaseScaffold {

	public void generate(String... params) {
		if (validateFile("AbstractModel.java")) {
			PrintWriter writer = null;
			try {
				File file = new File("src/main/java/br/com/scaffold/model/AbstractModel.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer);
				writer.println("");
				writer.println("@MappedSuperclass");
				writer.println("public abstract class AbstractModel<Long extends Serializable> implements Serializable {");
				writer.println("");
				writer.println("	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)");
				writer.println("	private Long id;");
				writer.println("");
				writer.println(" 	public Long getId() {");
				writer.println(" 		return this.id;");
				writer.println(" 	}");
				writer.println("");
				writer.println(" 	public void setId(Long id) {");
				writer.println(" 		this.id = id;");
				writer.println(" 	}");
				writer.println("}");
				writer.close();
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	public void imports(PrintWriter print) {
		print.println("package br.com.scaffold.model;");
		print.println("import javax.persistence.*;");
		print.println("import java.io.Serializable;");
	}

	public String generateParams(String params) {
		return null;
	}

	public boolean validateFile(String nameFile) {
		File f = new File("src/main/java/br/com/scaffold/model/" + nameFile);
		if(f.exists()) { 
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		
	}

}