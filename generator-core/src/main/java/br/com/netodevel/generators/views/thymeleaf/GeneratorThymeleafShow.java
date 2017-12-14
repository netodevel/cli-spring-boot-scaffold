package br.com.netodevel.generators.views.thymeleaf;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.view.GeneratorView;
import br.com.netodevel.core.view.GeneratorViewOptions;

/**
 * @author NetoDevel
 */
public class GeneratorThymeleafShow extends GeneratorView {

	public GeneratorThymeleafShow(GeneratorViewOptions generatorViewOptions) {
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
		return "template-show.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorViewOptions generatorViewOptions) {
		return javaStrings.replace("${template}", generatorViewOptions.getLayout())
				.replace("${className}", generatorViewOptions.getNameModel())
				.replace("paramClassName", generatorViewOptions.getNameModel().toLowerCase())
				.replace("/path_url", GeneratorConstants.SEPARATOR_DIR + generatorViewOptions.getNameModel().toLowerCase() + "s")
				.replace("${showAttributes}", AbstractThymeleafGenerate.generateShowParameters(generatorViewOptions.getNameModel(), generatorViewOptions.getParameters()));
	}
	
	public static void main(String[] args) {
		GeneratorViewOptions options = new GeneratorViewOptions()
				.setLayout("layout")
				.setNameModel("User")
				.setParameters("email:String name:String idade:Integer");
		
		new GeneratorThymeleafShow(options).generate("show.html");
	}
	
}
