package br.com.generate;

import java.io.PrintWriter;

public interface IBaseGenerateClean {

	public void generate(String className);
	public void imports(PrintWriter print);
	public boolean validateFile(String className);
	
}
