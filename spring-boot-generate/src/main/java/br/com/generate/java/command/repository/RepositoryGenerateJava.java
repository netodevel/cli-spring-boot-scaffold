package br.com.generate.java.command.repository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import br.com.generate.ReadScaffoldInfo;

public class RepositoryGenerateJava extends ReadScaffoldInfo {

	public RepositoryGenerateJava(String className) throws IOException {
		generate(className);
	}

	public void generate(String className) throws IOException {
		File javaTemplateFile = new File(getUserDir() + "/src/main/resources/templates/java/repository/template-repository.txt");
		String javaStrings = FileUtils.readFileToString(javaTemplateFile);

		javaStrings = javaStrings.replace("${package}", getPackage() + ".repository");
		javaStrings = javaStrings.replace("${package_model}", getPackage() + ".model");
		javaStrings = javaStrings.replace("${className}", className);

		File newJavaFile = new File(getPathPackage() + "repository/" + className + "Repository.java");
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("create " + getPathPackage() + "repository/" + className + "Repository.java");
	}

}
