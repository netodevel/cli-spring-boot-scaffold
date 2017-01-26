package br.com.generate;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class ReadTemplateFile extends AbstractGenerate {

	protected abstract String operationGenerate(String javaStrings, String nameClass, String parameters);

	private GenerateValidator validatorGenerate = new GenerateValidator();
	
	@Override
	public boolean generate(String nameClass, String parameters, String fileNameTemplate) throws IOException {
		if (validatorGenerate.validate(nameClass, parameters, getLayer())) {
			String javaStrings = readTemplateFile(fileNameTemplate);
			String newStrings = operationGenerate(javaStrings, nameClass, parameters);
			outPutFile(newStrings, nameClass);
			return true;
		}
		return false;
	}

}
