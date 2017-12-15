package br.com.netodevel.helpers;

import java.io.File;

/**
 * @author NetoDevel
 */
public class ValidatorHelper {
	
	public static boolean validateFileAlreadyExists(String pathFile) {
		File file = new File(pathFile);
		if (file.exists()) {
			return true;
		}
		return false;
	}
	
}
