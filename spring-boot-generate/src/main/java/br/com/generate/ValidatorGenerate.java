package br.com.generate;

import java.io.File;

import org.springframework.util.StringUtils;

/**
 * @author Jose
 */
public class ValidatorGenerate extends ReadScaffoldInfo {

	private SupportTypes supportTypes = new SupportTypes();
	
	public boolean validate(String nameClass, String parameters, String layer) {
		System.err.println(supportTypes.validate(parameters));
		System.err.println(getSetupDone());
		System.err.println(validateFileExists(nameClass, layer));
		
		if (supportTypes.validate(parameters) && getSetupDone() && !validateFileExists(nameClass, layer)) {
			return true;
		}
		return false;
	}
	
	public boolean validateFileExists(String nameClass, String layer) {
		String pathFile = getPathPackage() + layer + "/" + nameClass + StringUtils.capitalize(layer) + ".java";
		File f = new File(getUserDir() + pathFile);
		if(f.exists()) { 
			System.out.println("Error: file " + nameClass + StringUtils.capitalize(layer) + ".java" + " already exists.");
			return true;
		} else {
			return false;
		}
	}
	
}
