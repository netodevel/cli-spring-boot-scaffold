package br.com.netodevel.command.scaffold;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.netodevel.core.source.GeneratorOptions;
import br.com.netodevel.core.view.GeneratorViewOptions;
import br.com.netodevel.generators.java.controller.GeneratorController;
import br.com.netodevel.generators.java.controller.GeneratorControllerRest;
import br.com.netodevel.generators.java.model.GeneratorModel;
import br.com.netodevel.generators.java.repository.GeneratorRepository;
import br.com.netodevel.generators.java.service.GeneratorService;
import br.com.netodevel.generators.views.thymeleaf.GeneratorThymeleafForm;
import br.com.netodevel.generators.views.thymeleaf.GeneratorThymeleafIndex;
import br.com.netodevel.generators.views.thymeleaf.GeneratorThymeleafLayout;
import br.com.netodevel.generators.views.thymeleaf.GeneratorThymeleafShow;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldHandler extends OptionHandler {

	@SuppressWarnings("unused")
	private OptionSpec<String> nameEntity;

	@SuppressWarnings("unused")
	private OptionSpec<String> parametersEntity;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> rest;
	
	@SuppressWarnings("unused")
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
		this.rest = option(Arrays.asList("rest", "r"), "Generator Rest Controller").withOptionalArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		String rest = (String) options.valueOf("r");
		generateScaffoldJava(nameClass.trim(), parametersClass, rest);
		return ExitStatus.OK;
	}

	
	private void generateScaffoldJava(String nameClass, String parametersClass, String rest) throws IOException {
		GeneratorOptions generatorOptions = new GeneratorOptions()
				.setNameModel(nameClass)
				.setParameters(parametersClass);

		GeneratorViewOptions generatorViewOptions = new GeneratorViewOptions()
				.setLayout("layout")
				.setNameModel(nameClass)
				.setParameters(parametersClass);
		
		//TODO: factory of languages..
		new GeneratorModel(generatorOptions).generate();	
		new GeneratorRepository(generatorOptions).generate();
		new GeneratorService(generatorOptions).generate();
		
		if (rest != null && rest.equals("true")) {
			new GeneratorControllerRest(generatorOptions).generate();
		} else {
			new GeneratorController(generatorOptions).generate();
		}
		
		//TODO: factory of template engines..
		new GeneratorThymeleafLayout().generate("layout.html");
		new GeneratorThymeleafIndex(generatorViewOptions).generate("index.html");
		new GeneratorThymeleafForm(generatorViewOptions).generate("form.html");
		new GeneratorThymeleafShow(generatorViewOptions).generate("show.html");
	}
	
}
