package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;

import br.com.generate.Layers;
import br.com.generate.java.command.repository.RepositoryGenerateJava;
import br.com.netodevel.generate.utils.ConvertFileUtils;

public class RepositoryGenerateTest {
	
	
	@Test
	public void testGenerateRepository() throws IOException {
		new RepositoryGenerateJava().generate("User", null, "template-repository.txt");
		File repositoryJavaFile = new File("src/main/java/br/com/example/repository/UserRepository.java");
	
		File newTextFile = ConvertFileUtils.convertJavaToText(repositoryJavaFile, Layers.REPOSITORY, "UserRepositoryTest.txt");
		
		boolean validateFileEquals = FileUtils.contentEquals(newTextFile, new File("src/test/resources/templates/java/repository/UserRepository.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}
	
	@After
	public void tearDown() {
		File fileJava = new File("src/main/java/br/com/example/repository/UserRepository.java");
		File fileText = new File("src/test/resources/templates/java/repository/UserRepositoryTest.txt");

//		FileUtils.deleteDirectory("src/main/java/br/com/example/repository");
		
		fileJava.delete();
		fileText.delete();
	}
	
}
