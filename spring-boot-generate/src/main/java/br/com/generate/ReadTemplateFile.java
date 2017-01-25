package br.com.generate;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class ReadTemplateFile extends AbstractGenerate {

	protected abstract String operationGenerate(String javaStrings, String nameClass, String parameters);

	private ValidatorGenerate validatorGenerate = new ValidatorGenerate();
	
	@Override
	public void generate(String nameClass, String parameters, String fileNameTemplate) throws IOException {
		if (validatorGenerate.validate(nameClass, parameters, getLayer())) {
			String javaStrings = readTemplateFile(fileNameTemplate);
			String newStrings = operationGenerate(javaStrings, nameClass, parameters);
			outPutFile(newStrings, nameClass);
		}
	}

}
