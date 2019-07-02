package br.com.generate.validators;

import java.io.File;

import br.com.generate.Layers;
import br.com.generate.helpers.ScaffoldInfoHelper;
import org.springframework.util.StringUtils;

/**
 * @author Jose
 */
public class GenerateValidator extends ScaffoldInfoHelper {

	private TypeValidator typeValidator = new TypeValidator();
	
	public boolean validate(String nameClass, String parameters, String layer) {
		if (typeValidator.validate(parameters, layer) && getSetupDone() && !validateFileExists(nameClass, layer)) {
			return true;
		}
		return false;
	}
	
	public boolean validateFileExists(String nameClass, String layer) {
		String pathFile = "";
		if (layer.equals(Layers.MODEL)) {
			pathFile = "/" + getPathPackage() + layer + "/" + nameClass + ".java";
		} else {
			pathFile = "/" + getPathPackage() + layer + "/" + nameClass + StringUtils.capitalize(layer) + ".java";
		}
		File f = new File(getUserDir() + pathFile);
		if(f.exists()) { 
			System.out.println("Error: file " + nameClass + StringUtils.capitalize(layer) + ".java" + " already exists.");
			return true;
		} else {
			return false;
		}
	}
	
}
