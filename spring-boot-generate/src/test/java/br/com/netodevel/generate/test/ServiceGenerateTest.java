package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.generate.Layers;
import br.com.generate.java.command.service.ServiceGenerateJava;
import br.com.netodevel.generate.utils.FileGeneratorTestUtils;

public class ServiceGenerateTest {

	File serviceGeneratorFile;
	File convertServiceToText;

	@Before
	public void setUp() throws IOException {
		new ServiceGenerateJava().generate("User", null, "template-service.txt");
		serviceGeneratorFile = new File("src/main/java/br/com/example/service/UserService.java");
		convertServiceToText = FileGeneratorTestUtils.convertJavaToText(serviceGeneratorFile, Layers.SERVICE, "UserServiceTest.txt");
	}

	@Test
	public void testGenerateService() throws IOException {
		boolean validateFileEquals = FileUtils.contentEquals(convertServiceToText, new File("src/test/resources/templates/java/service/UserService.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}

	@Test
	public void testValidateFileExists() throws IOException {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		new ServiceGenerateJava().generate("User", null, "template-service.txt");
		String outPutExpected = "Error: file UserService.java already exists.";
		assertEquals("should be true", outPutExpected.trim(), out.toString().trim());
	}

	@After
	public void tearDown() throws IOException {
		FileGeneratorTestUtils.deleteFileAndDirectory(serviceGeneratorFile, convertServiceToText);
	}

}
