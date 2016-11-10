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
        String optionValue = optionValues[2];

		switch (command){

			case GENERATE_PROJECT:

                new ProjectGenerate(optionValue);
				break;

			case GENERATE_MODEL:
                new ModelGenerate(optionValue, Parameter.getParametersGenerate(optionValues));
				break;

			case GENERATE_REPOSITORY:

                new RepositoryGenerate(optionValue);
				break;

			case GENERATE_SERVICE:

                new ServiceGenerate(optionValue);
				break;

			case GENERATE_CONTROLLER:

                new ControllerGenerate(optionValue);
				break;

			case GENERATE_SCAFFOLD:

                new ModelGenerate(optionValue, Parameter.getParametersGenerate(optionValues));

                new RepositoryGenerate(optionValue);

                new ServiceGenerate(optionValue);

                new ControllerGenerate(optionValue);

				break;
		}

	}

}
