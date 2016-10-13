package br.com.generate;

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
				modelGenerate.generate(params[3], paramTotal);
			}
			
			if (command.equals("exit")) {
				loop = false;
				System.out.println("bye.");
			}
		}
	}
}
