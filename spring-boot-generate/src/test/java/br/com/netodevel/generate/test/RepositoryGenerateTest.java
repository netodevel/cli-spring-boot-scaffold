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

	@Test
	public void testValidateFileExists() throws IOException {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		new RepositoryGenerateJava().generate("User", null, "template-repository.txt");
		String outPutExpected = "Error: file UserRepository.java already exists.";
		assertEquals("should be true", outPutExpected.trim(), out.toString().trim());

	}

	@After
	public void tearDown() throws IOException {
		FileGeneratorTestUtils.deleteFileAndDirectory(repositoryGeneratorFile, convertRepositoryToText);
	}


}
