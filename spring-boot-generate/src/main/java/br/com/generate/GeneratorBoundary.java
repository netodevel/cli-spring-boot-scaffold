package br.com.generate;

import java.io.IOException;

public interface GeneratorBoundary {

	boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException;
	
	String getLayer();
}
