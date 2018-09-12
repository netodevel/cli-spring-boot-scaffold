package br.com.generate;

import java.io.IOException;

public interface Generator {

	// parameters -> hashMap, fileNameTemplate morre!, todos parametros vao virar modelo.
	public boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException;

	// pq layer? 
	public String getLayer();
}
