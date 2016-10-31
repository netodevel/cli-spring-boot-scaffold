package br.com.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PomGenerate implements IGenerate {

	@Override
	public void generate(String... params) {
		String BASE_DIR = params[0];
		String NAME_PROJECT = params[1];
		
		PrintWriter writer = null;
		try {
			File file = new File(BASE_DIR + "\\pom.xml");
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
			writer.println("<project xmlns='http://maven.apache.org/POM/4.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd'>");
			writer.println("	<modelVersion>4.0.0</modelVersion>");
			writer.println("  	<groupId>" + NAME_PROJECT + "</groupId>");
			writer.println("	<artifactId>" + NAME_PROJECT + "</artifactId>");
			writer.println("	<version>0.0.1-SNAPSHOT</version>");
			writer.println("</project>");
			writer.close();
			System.out.println("create pom.xml");
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
