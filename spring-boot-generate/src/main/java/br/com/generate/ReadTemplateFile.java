package br.com.generate;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class ReadTemplateFile extends AbstractGenerate {

	protected abstract String operationGenerate(String javaStrings, String nameClass, String parameters);

	@Override
	public void generate(String nameClass, String parameters, String fileNameTemplate) throws IOException {

		String javaStrings = readTemplateFile(fileNameTemplate);

		String newStrings = operationGenerate(javaStrings, nameClass, parameters);

		outPutFile(newStrings, nameClass);
	}
	

}
