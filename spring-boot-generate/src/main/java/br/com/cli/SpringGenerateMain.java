package br.com.cli;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.com.factory.GenerateFactory;
import br.com.generate.Command;
import br.com.generate.DatabaseConfiguration;
import br.com.generate.Parameter;

/**
 * 
 * @author NetoDevel
 *
 */
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

		GenerateFactory generateFactory = new GenerateFactory();
		generateFactory.getStrategy(command.getCommand(), projectName, Parameter.getParametersGenerate(optionValues), database);
	}

}
