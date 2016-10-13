package br.com.generate;

import java.io.PrintWriter;

public interface IGenerate {

	public boolean generate(String... params);
	public void imports(PrintWriter print);
	public String generateParams(String params);
}
