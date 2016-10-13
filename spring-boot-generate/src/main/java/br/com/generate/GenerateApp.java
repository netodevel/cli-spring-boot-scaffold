package br.com.generate;

import java.util.List;
import java.util.Scanner;

public class GenerateApp {
	private static Scanner reader;
	
	public static void main(String[] args) {
		reader = new Scanner(System.in);
		System.out.println("Spring boot generate...");
		boolean loop = true;

		while (loop) {
			System.out.println("Enter with command: ");
			String command = reader.nextLine();
			
			if (command.startsWith(Commands.MODEL)) {
				ModelGenerate modelGenerate = new ModelGenerate();
				String[] params = command.split(" ");
				
				String paramTotal = "";
				for (int i = 4; i < params.length; i++) {
					paramTotal += " " + params[i];
				}
				
				if (GenerateApp.validateParams(paramTotal)) {
					modelGenerate.generate(params[3], paramTotal);
				}
			}
			
			if (command.equals(Commands.EXIT)) {
				loop = false;
				System.out.println("bye.");
			}
		}

		
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
		if (validate == false) {
			System.out.println("Error sintaxe!");
		}
		return validate;
	}
}
