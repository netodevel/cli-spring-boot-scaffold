package br.com.netodevel.generators.views.thymeleaf;

import br.com.netodevel.core.resources.GeneratorResource;
import br.com.netodevel.core.resources.GeneratorResourceOptions;

/**
 * @author NetoDevel
 */
public class GeneratorThymeleafLayout extends GeneratorResource {

	@Override
	public String folder() {
		return ROOT;
	}

	@Override
	public String layer() {
		return "thymeleaf";
	}

	@Override
	public String templateFile() {
		return "template-layout.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorResourceOptions generateOptions) {
		return javaStrings;
	}
	
	public static void main(String[] args) {
		new GeneratorThymeleafLayout().generate("layout.html");
	}
	
}
