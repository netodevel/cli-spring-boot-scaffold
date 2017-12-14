package br.com.netodevel.core.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.ReadScaffoldInfo;

/**
 * @author NetoDevel
 */
public abstract class AbstractGeneratorResource extends ReadScaffoldInfo implements GeneratorResourceBase {
	
	public String loadTemplateFileResources(String fileName) throws IOException {
		InputStream in = getClass().getResourceAsStream("/templates/resources/" + layer() + GeneratorConstants.SEPARATOR_DIR + fileName);
		return IOUtils.toString(in, "UTF-8"); 
	}
	
	public void createNewResource(String javaStrings, String fileOutPutName) throws IOException {
		fileOutPutName = nameResourceToGenerate(fileOutPutName);

		File newJavaFile = new File(fileOutPutName);
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("created");
	}

	private String nameResourceToGenerate(String fileOutPutName) {
		fileOutPutName = getPathResources() + GeneratorConstants.SEPARATOR_DIR 
						+ folder() + GeneratorConstants.SEPARATOR_DIR 
						+ fileOutPutName;
		
		return fileOutPutName;
	}
	
}
