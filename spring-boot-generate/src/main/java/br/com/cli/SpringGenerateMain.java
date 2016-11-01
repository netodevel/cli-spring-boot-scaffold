package br.com.cli;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.com.generate.Commands;
import br.com.generate.ControllerGenerate;
import br.com.generate.ModelGenerate;
import br.com.generate.ProjectGenerate;
import br.com.generate.RepositoryGenerate;
import br.com.generate.ServiceGenerate;

public class SpringGenerateMain {

	private static Logger LOGGER = Logger.getLogger(SpringGenerateMain.class.getName());
	private static Options options = new Options();

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		options.addOption(OptionBuilder.withLongOpt("spring").withDescription("path to generates").hasArgs().withArgName("PATHS").create());

		CommandLineParser parser = new GnuParser();
		CommandLine line = null;
		
		try {
			line = parser.parse(options, args, true);
			LOGGER.log(Level.WARNING, "stay here", "arguments");
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}
		
		String [] arguments = line.getOptionValues("spring");
		LOGGER.log(Level.WARNING, arguments.toString(), "arguments");
		
		if (arguments[1].equals(Commands.GENERATE_PROJECT)) {
			String projectName = arguments[2];
			ProjectGenerate projectGenerate = new ProjectGenerate();
			projectGenerate.generate(projectName);
		}
		
		if (arguments[1].equals(Commands.GENERATE_MODEL)) {
			String className = arguments[2];
			String parameters = getParametersGenerate(arguments);
			ModelGenerate modelGenerate = new ModelGenerate();
			modelGenerate.generate(className, parameters);
		}
		
		if (arguments[1].equals(Commands.GENERATE_REPOSITORY)) {
			String className = arguments[2];
			RepositoryGenerate repositoryGenerate = new RepositoryGenerate();
			repositoryGenerate.generate(className);
		}
		
		if (arguments[1].equals(Commands.GENERATE_SERVICE)) {
			String className = arguments[2];
			ServiceGenerate serviceGenerate = new ServiceGenerate();
			serviceGenerate.generate(className);
		}
		
		if (arguments[1].equals(Commands.GENERATE_CONTROLLER)) {
			String className = arguments[2];
			ControllerGenerate controllerGenerate = new ControllerGenerate();
			controllerGenerate.generate(className);
		}
		
		if (arguments[1].equals(Commands.GENERATE_SCAFFOLD)) {
			String className = arguments[2];
			String parameters = getParametersGenerate(arguments);
			
			/**
			 * Generate model
			 */
			ModelGenerate modelGenerate = new ModelGenerate();
			modelGenerate.generate(className, parameters);
			
			/**
			 * Generate repository
			 */
			RepositoryGenerate repositoryGenerate = new RepositoryGenerate();
			repositoryGenerate.generate(className);
			
			/**
			 * Generate Service
			 */
			ServiceGenerate serviceGenerate = new ServiceGenerate();
			serviceGenerate.generate(className);
			
			/**
			 * Generate Controller
			 */
			ControllerGenerate controllerGenerate = new ControllerGenerate();
			controllerGenerate.generate(className);
		}
		
		
	}

	private static String getParametersGenerate(String[] arguments) {
		String parameters = "";
		for (int i = 3; i < arguments.length; i++) {
			parameters += " " + arguments[i];
		}
		return parameters;
	}

}
