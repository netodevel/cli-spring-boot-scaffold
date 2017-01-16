package br.com.generate.java;

public class TestsGenerateJava {

	public static void main(String[] args) {
		new ModelGenerateJava("User", "name:String email:String");
		new RepositoryGenerateJava("User");
		new ServiceGenerateJava("User");
		new ControllerGenerateJava("User");
	}
	
}
