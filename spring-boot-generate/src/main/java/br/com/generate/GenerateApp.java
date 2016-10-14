package br.com.generate;

import java.util.List;
import java.util.Scanner;

public class GenerateApp {
	private static Scanner reader;
	
	public static void main(String[] args) {
		reader = new Scanner(System.in);
		System.out.println("Spring Boot Kotlin Scaffold Generate... ");
		boolean loop = true;
		while (loop) {
			System.out.println("Enter with a command: ");
			String command = reader.nextLine();
			
			if (command.startsWith(Commands.GENERATE_MODEL)) {
				ModelGenerate modelGenerate = new ModelGenerate();
				String[] params = command.split(" ");
				String paramTotal = listParams(params);
				if (GenerateApp.validateParams(paramTotal)) {
					modelGenerate.generate(params[3], paramTotal);
				} else {
					System.out.println("error sintaxe!");
				}
			} else if (command.startsWith(Commands.GENERATE_REPOSITORY)) {
				RepositoryGenerate repositoryGenerate = new RepositoryGenerate();
				String[] params = command.split(" ");
				String paramTotal = listParams(params);
				repositoryGenerate.generate(params[3], paramTotal);
			}
			
			if (command.equals(Commands.EXIT)) {
				loop = false;
				System.out.println("bye.");
			}
		}
	}

	private static String listParams(String[] params) {
		String paramTotal = "";
		for (int i = 4; i < params.length; i++) {
			paramTotal += " " + params[i];
		}
		return paramTotal;
	}
	
	public static boolean validateParams(String parmsTotal) {
		String[] paramsSplit = parmsTotal.split(" ");
		List<String> types = TypesKotlin.listTypesKotlin;
		boolean validate = false;
		for (int i = 1; i < paramsSplit.length; i++) {
			String[] splitVar = paramsSplit[i].split(":");
			String typeVar = splitVar[1];
			for (int j = 0; j < types.size(); j++) {
				if (typeVar.equals(types.get(j))) {
					validate = true;
				} 
			}
		}
		return validate;
	}
}
