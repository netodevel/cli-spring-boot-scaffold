package br.com.netodevel.helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author NetoDevel
 */
public class FileHelper {

	public static void createNewFileFromGenerator(File file, String replaceStrings, String outputFileName) throws IOException {
		if (!ValidatorHelper.validateFileAlreadyExists(file.getAbsolutePath())) {
			FileUtils.writeStringToFile(file, replaceStrings);
			System.out.println("created " + outputFileName);
		} else {
			System.out.println("Error: "+ outputFileName + " File already exists.");
		}
	}
	
}
