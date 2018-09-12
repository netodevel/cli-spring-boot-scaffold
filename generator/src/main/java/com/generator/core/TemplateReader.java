package com.generator.core;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class TemplateReader {

	public String read(String templatePath) throws IOException {
		InputStream inputStream = getClass().getResourceAsStream(templatePath);
		String outputText = IOUtils.toString(inputStream, "UTF-8"); 
		return outputText;
	}
	
}
