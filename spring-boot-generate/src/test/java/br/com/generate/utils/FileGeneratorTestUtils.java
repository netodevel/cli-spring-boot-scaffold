package br.com.generate.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileGeneratorTestUtils {

	public static File convertJavaToText(File file, String layer, String outPutFileName) throws FileNotFoundException, IOException {
		InputStream in =  new FileInputStream(file);
		String theString = IOUtils.toString(in, "UTF-8");
		File newTextFile = new File("src/test/resources/templates/java/" + layer + "/" + outPutFileName);
		FileUtils.writeStringToFile(newTextFile, theString);
		return newTextFile;
	}
	
	public static void deleteFileAndDirectory(File... files) throws IOException {
		for (File file : files) {
			FileDeleteStrategy.FORCE.delete(file);
		}
//		FileUtils.forceDelete(new File("src/main/java/br/com/example"));
	}
	
}
