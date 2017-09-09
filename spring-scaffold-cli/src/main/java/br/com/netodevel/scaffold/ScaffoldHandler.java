package br.com.netodevel.scaffold;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import br.com.generate.java.command.controller.ControllerGenerator;
import br.com.generate.java.command.model.ModelGenerator;
import br.com.generate.java.command.repository.RepositoryGenerator;
import br.com.generate.java.command.service.ServiceGenerator;
import br.com.generate.thymeleaf.ThymeleafGenerator;
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
	private OptionSpec<String> language;
	
	@Override
	protected void options() {
		this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
		this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
	}
	
	@Override
	protected ExitStatus run(OptionSet options) throws Exception {
		String nameClass = (String) options.valueOf("n");
		String parametersClass = (String) options.valueOf("p");
		generateJava(nameClass.trim(), parametersClass);
		return ExitStatus.OK;
	}

	private void generateJava(String nameClass, String parametersClass) throws IOException {
		generateScaffoldJava(nameClass, parametersClass);
	}
	
	private void generateScaffoldJava(String nameClass, String parametersClass) throws IOException {
		try {
			if (new ModelGenerator().generate(nameClass, parametersClass, "template-model.txt")) {
				new RepositoryGenerator().generate(nameClass, null, "template-repository.txt");
				new ServiceGenerator().generate(nameClass, null, "template-service.txt");
				new ControllerGenerator().generate(nameClass, null, "template-controller.txt");
				new ThymeleafGenerator(nameClass, parametersClass);
				//new Migrations().create(nameClass, parametersClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
