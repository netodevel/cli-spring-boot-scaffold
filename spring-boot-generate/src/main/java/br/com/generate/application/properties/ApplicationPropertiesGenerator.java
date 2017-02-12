package br.com.generate.application.properties;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import br.com.generate.ReadScaffoldInfo;

public class ApplicationPropertiesGenerator extends ReadScaffoldInfo {

	public ApplicationPropertiesGenerator() throws IOException {
		if (validate()) {
			generate();
		}
	}
	
	public void generate() throws IOException {
		String strings = IOUtils.toString(getClass().getResourceAsStream("/templates/resources/template-application.properties.txt"), null);

		String nameDatabase = getNameDatabase();
		String userDataBase = getUserDatabase();
		String passwordDatabase = getPassWordDatabase();
		
		strings = strings.replace("{nameDatabase}", nameDatabase);
		strings = strings.replace("{userDatabase}", userDataBase);
		strings = strings.replace("{passwordDatabase}", passwordDatabase);
		
		File newFile = new File(getUserDir() + "/src/main/resources/application.properties");
		FileUtils.writeStringToFile(newFile, strings);
		System.out.println("create /src/main/resources/application.properties");
	}
	
	public boolean validate() throws IOException {
		String pathFile = "/src/main/resources/application.properties";
		File f = new File(getUserDir() + pathFile);
		if(f.exists()) { 
			String strings = FileUtils.readFileToString(f);
			if (strings.equals("") || strings == null) {
				return true;
			} 
		} else {
			return true;
		}
		return false;
	}
	
}
