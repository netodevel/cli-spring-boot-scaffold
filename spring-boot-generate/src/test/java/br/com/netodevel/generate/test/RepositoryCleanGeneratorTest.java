package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.generate.Layers;
import br.com.generate.java.command.repository.RepositoryCleanGenerator;
import br.com.netodevel.generate.utils.FileGeneratorTestUtils;

public class RepositoryCleanGeneratorTest {

	File repositoryCleanGeneratorFile;
	File convertRepositoryCleanToText;

	@Before
	public void setUp() throws IOException {
		new RepositoryCleanGenerator().generate("User", null, "template-clean-repository.txt");
		repositoryCleanGeneratorFile = new File("src/main/java/br/com/example/repository/UserRepository.java");
		convertRepositoryCleanToText = FileGeneratorTestUtils.convertJavaToText(repositoryCleanGeneratorFile, Layers.REPOSITORY, "UserCleanRepositoryTest.txt");
	}

	@Test
	public void testGenerateRespositoryClean() throws IOException {
		boolean validateFileEquals = FileUtils.contentEquals(convertRepositoryCleanToText, new File("src/test/resources/templates/java/repository/UserCleanRepository.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}

	@Test
	public void testValidateFileExists() throws IOException {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		new RepositoryCleanGenerator().generate("User", null, "template-clean-repository.txt");
		String outPutExpected = "Error: file UserRepository.java already exists.";
		assertEquals("should be true", outPutExpected.trim(), out.toString().trim());
	}

	@After
	public void tearDown() throws IOException {
		FileGeneratorTestUtils.deleteFileAndDirectory(repositoryCleanGeneratorFile, convertRepositoryCleanToText);
	}
}
