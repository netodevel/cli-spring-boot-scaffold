package br.com.netodevel.generators.views.thymeleaf;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.view.GeneratorView;
import br.com.netodevel.core.view.GeneratorViewOptions;

/**
 * @author NetoDevel
 */
public class GeneratorThymeleafIndex extends GeneratorView {

	private AbstractThymeleafGenerate abstractThymeleafGenerate;
	
	public GeneratorThymeleafIndex(GeneratorViewOptions generatorViewOptions) {
		super(generatorViewOptions);
		abstractThymeleafGenerate = new AbstractThymeleafGenerate();
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
		return "template-index.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions) {
		return javaStrings.replace("${template}",generatorViewOptions.getLayout())
				.replace("paramClassName", generatorViewOptions.getNameModel().toLowerCase())
				.replace("eachParam", GeneratorConstants.LIST_EACH + generatorViewOptions.getNameModel().toLowerCase())
				.replace("url_path", GeneratorConstants.SEPARATOR_DIR + generatorViewOptions.getNameModel().toLowerCase() + "s")
				.replace("${th_attributes}", abstractThymeleafGenerate.generateThParameters(generatorViewOptions.getParameters()))
				.replace("${td_attributes}", abstractThymeleafGenerate.generateTdParameters(generatorViewOptions.getNameModel(), generatorViewOptions.getParameters()))
				.replace("${className}", generatorViewOptions.getNameModel());
	}
	
	public static void main(String[] args) {
		GeneratorViewOptions options = new GeneratorViewOptions()
				.setNameModel("User")
				.setParameters("name:String email:String")
				.setLayout("layout");
		new GeneratorThymeleafIndex(options).generate("index.html");
	}

}