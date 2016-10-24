package br.com.cli;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.com.generate.ModelGenerate;

public class Cli {

	private static final Logger log = Logger.getLogger(Cli.class.getName());
	private String[] args = null;
	private Options options = new Options();
	
	public Cli(String[] args) {
		this.args = args;
		options.addOption("h", "help", false, "show help");
		options.addOption("generateModel", true , "generate model");
	}
	
	public void parse() {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("h")) {
				help();
			}
			if (cmd.hasOption("generateModel")) {
				String [] argumentos = cmd.getOptionValues("generateModel");
				ModelGenerate modelGenerate = new ModelGenerate();
				String paramTotal = listParams(argumentos);
				modelGenerate.generate(argumentos[0], paramTotal);
				log.log(Level.INFO, "invoke spring data-jpa");
				log.log(Level.INFO, "create src/main/java/br/com/scaffold/model/" + argumentos[0] + ".kt");
			}
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}
		
	}
	
	private static String listParams(String[] params) {
		String paramTotal = "";
		for (int i = 4; i < params.length; i++) {
			paramTotal += " " + params[i];
		}
		return paramTotal;
	}

	private void help() {
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp("Main", options);
		System.exit(0);
	}
	
}
