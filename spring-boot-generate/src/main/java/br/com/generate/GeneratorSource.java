package br.com.generate;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorSource extends AbstractGenerate {

	private GenerateValidator validator = new GenerateValidator();
	
	protected abstract String operationGenerate(String template, String nameClass, String parameters);
	
	@Override
	public boolean generate(String className, String parameters, String fileNameTemplate) throws IOException {
		if (validator.validate(className, parameters, getLayer())) {
			String template = readTemplateFile(fileNameTemplate);
			String outputText = operationGenerate(template, className, parameters);
			outPutFile(outputText, className);
			return true;
		}
		return false;
	}

}
