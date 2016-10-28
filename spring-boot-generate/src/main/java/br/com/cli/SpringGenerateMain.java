package br.com.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.com.generate.Commands;
import br.com.generate.ModelGenerate;
import br.com.generate.RepositoryGenerate;

public class SpringGenerateMain {

	private static Options options = new Options();

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		options.addOption(OptionBuilder.withLongOpt("spring").withDescription("path to generates").hasArgs().withArgName("PATHS").create());

		CommandLineParser parser = new GnuParser();
		CommandLine line = null;
		
		try {
			line = parser.parse(options, args, true);
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}

		String [] arguments = line.getOptionValues("spring");
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
		
	}

	private static String getParametersGenerate(String[] arguments) {
		String parameters = "";
		for (int i = 3; i < arguments.length; i++) {
			parameters += " " + arguments[i];
		}
		return parameters;
	}

}
