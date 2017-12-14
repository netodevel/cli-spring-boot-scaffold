package br.com.netodevel.generators.views.thymeleaf;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.view.GeneratorView;
import br.com.netodevel.core.view.GeneratorViewOptions;

/**
 * @author NetoDevel
 */
public class GeneratorThymeleafCleanIndex extends GeneratorView {

	public GeneratorThymeleafCleanIndex(GeneratorViewOptions generatorViewOptions) {
		super(generatorViewOptions);
	}

	@Override
	public String folder() {
		return GeneratorConstants.FOLDER_THYMELEAF + GeneratorConstants.SEPARATOR_DIR 
				+ this.generatorViewOptions.getNameModel().toLowerCase();
	}

	@Override
	public String layer() {
		return "thymeleaf";
	}

	@Override
	public String templateFile() {
		return "template-clean-index.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions) {
		return javaStrings.replace("${template}",generatorViewOptions.getLayout())
				.replace("${className}", generatorViewOptions.getNameModel());
	}
	
	public static void main(String[] args) {
		GeneratorViewOptions options = new GeneratorViewOptions()
				.setNameModel("User")
				.setLayout("layout");
		
		new GeneratorThymeleafCleanIndex(options).generate("index.html");
	}

}
