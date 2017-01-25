package br.com.generate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;


public abstract class AbstractGenerate extends ReadScaffoldInfo implements IGenerate {

	public String readTemplateFile(String fileNameTemplate) throws IOException {
		InputStream in = getClass().getResourceAsStream("/templates/java/" + getLayer() + "/" + fileNameTemplate);
		String theString = IOUtils.toString(in, "UTF-8"); 
		return theString;
	}

	public void outPutFile(String javaStrings, String fileOutPutName) throws IOException {
		String nameFileOutPut;
		if (getLayer().equals(Layers.MODEL)) {
			nameFileOutPut = getPathPackage() + getLayer() + "/" + fileOutPutName + ".java";
		} else {
			nameFileOutPut = getPathPackage() + getLayer() + "/" + fileOutPutName + StringUtils.capitalize(getLayer()) + ".java";
		}
		File newJavaFile = new File(nameFileOutPut);
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage()  + getLayer() + "/" + fileOutPutName + StringUtils.capitalize(getLayer()) + ".java");
	}

}
