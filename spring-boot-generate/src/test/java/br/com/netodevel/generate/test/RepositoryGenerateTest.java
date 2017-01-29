package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.generate.Layers;
import br.com.generate.java.command.repository.RepositoryGenerateJava;
import br.com.netodevel.generate.utils.FileGeneratorTestUtils;

public class RepositoryGenerateTest {
	
	File repositoryGeneratorFile;
	File convertRepositoryToText;
	
	@Before
	public void setUp() throws IOException {
		new RepositoryGenerateJava().generate("User", null, "template-repository.txt");
		repositoryGeneratorFile = new File("src/main/java/br/com/example/repository/UserRepository.java");
		convertRepositoryToText = FileGeneratorTestUtils.convertJavaToText(repositoryGeneratorFile, Layers.REPOSITORY, "UserRepositoryTest.txt");
		
	}
	
	@Test
	public void testGenerateRepository() throws IOException {
		boolean validateFileEquals = FileUtils.contentEquals(convertRepositoryToText, new File("src/test/resources/templates/java/repository/UserRepository.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}
	
	@After
	public void tearDown() throws IOException {
		FileGeneratorTestUtils.deleteFileAndDirectory(repositoryGeneratorFile, convertRepositoryToText);
	}
	
	
}
