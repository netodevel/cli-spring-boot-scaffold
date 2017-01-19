package br.com.generate.java.command;

import br.com.generate.java.command.controller.ControllerScaffoldGenerateJava;
import br.com.generate.java.command.service.ServiceGenerateJava;

public class TestsGenerateJava {

	public static void main(String[] args) {
		new ModelGenerateJava("User", "name:String email:String");
		new RepositoryGenerateJava("User");
		new ServiceGenerateJava("User");
		new ControllerScaffoldGenerateJava("User");
	}
	
}
