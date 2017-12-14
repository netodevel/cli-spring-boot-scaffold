package br.com.netodevel.generators.views.thymeleaf;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.view.GeneratorView;
import br.com.netodevel.core.view.GeneratorViewOptions;

/**
 * @author NetoDevel
 */
public class GeneratorThymeleafForm extends GeneratorView {

	public GeneratorThymeleafForm(GeneratorViewOptions generatorViewOptions) {
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
		return "template-form.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions) {
		return javaStrings.replace("${template}", generatorViewOptions.getLayout())
				.replace("${className}", generatorViewOptions.getNameModel())
				.replace("paramClassName", generatorViewOptions.getNameModel().toLowerCase())
				.replace("${url_path}", GeneratorConstants.SEPARATOR_DIR + generatorViewOptions.getNameModel().toLowerCase() + "s")
				.replace("${input_parameters}", AbstractThymeleafGenerate.generateInputParameters(generatorViewOptions.getParameters()));
	}
	
	public static void main(String[] args) {
		GeneratorViewOptions options = new GeneratorViewOptions()
				.setLayout("layout")
				.setNameModel("User")
				.setParameters("email:String name:String idade:Integer");
		
		new GeneratorThymeleafForm(options).generate("form.html");
	}
	
}
