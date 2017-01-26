package br.com.generate;

import java.io.IOException;

public interface IGenerate {

	public boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException;
	
	public String getLayer();
}
