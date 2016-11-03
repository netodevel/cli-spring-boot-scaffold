package br.com.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ApplicationPropertiesGenerate implements IGenerate {

	@Override
	public void generate(String... params) {
		String BASE_DIR = params[0];
		PrintWriter writer = null;
		try {
			File file = new File(BASE_DIR + "\\src\\main\\resources\\application.properties");
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
			writer.println("spring.datasource.url=jdbc:mysql://localhost/apikotlin");
			writer.println("spring.datasource.username=root");
			writer.println("spring.datasource.password=root");
			writer.println("spring.datasource.tomcat.test-on-borrow=true");
			writer.println("spring.datasource.tomcat.validation-query=SELECT 1");
			writer.println("spring.datasource.sql-script-encoding=UTF-8");
			writer.println("");
			writer.println("spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy");
			writer.println("spring.jpa.openInView=true");
			writer.println("spring.jpa.show-sql=true");
			writer.println("spring.jpa.hibernate.ddl-auto=create");
			writer.close();
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
