package br.com.generate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;


public abstract class AbstractGenerate extends ReadScaffoldInfo implements IGenerate {
	
	public String readTemplateFile(String fileNameTemplate) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/" + getLayer() + "/" + fileNameTemplate);
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);
		return javaStrings;
	}

	public void outPutFile(String javaStrings, String fileOutPutName) throws IOException {
		File newJavaFile = new File(getPathPackage() + getLayer() + "/" + fileOutPutName + StringUtils.capitalize(getLayer()) + ".java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage()  + getLayer() + "/" + fileOutPutName + StringUtils.capitalize(getLayer()) + ".java");
	}
	
	
}
