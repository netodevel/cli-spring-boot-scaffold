package br.com.cli;

import java.util.logging.Logger;

import br.com.generate.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class SpringGenerateMain {

	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(SpringGenerateMain.class.getName());
	private static Options options = new Options();

	public static final int PROJECT_NAME = 2;
	public static final int DATABASE = 3;

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
		
		String [] optionValues = line.getOptionValues("spring");
		Command command = Command.getCommand(optionValues[1]);
        String projectName = optionValues[PROJECT_NAME];
		String database = DatabaseConfiguration.getDataBase(optionValues);

		switch (command){

			case GENERATE_PROJECT:

                new ProjectGenerate(projectName, database);
				break;

			case GENERATE_MODEL:
                new ModelGenerate(projectName, Parameter.getParametersGenerate(optionValues));
				break;

			case GENERATE_REPOSITORY:

                new RepositoryGenerate(projectName);
				break;

			case GENERATE_SERVICE:

                new ServiceGenerate(projectName);
				break;

			case GENERATE_CONTROLLER:

                new ControllerGenerate(projectName);
				break;

			case GENERATE_SCAFFOLD:

                new ModelGenerate(projectName, Parameter.getParametersGenerate(optionValues));

                new RepositoryGenerate(projectName);

                new ServiceGenerate(projectName);

                new ControllerGenerate(projectName);

				break;
		}

	}

}
