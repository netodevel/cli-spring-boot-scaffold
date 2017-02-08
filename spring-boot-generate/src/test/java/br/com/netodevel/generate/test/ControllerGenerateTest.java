package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.generate.Layers;
import br.com.generate.java.command.controller.ControllerGenerateJava;
import br.com.netodevel.generate.utils.FileGeneratorTestUtils;

public class ControllerGenerateTest {

	File controllerGeneratorFile;
	File convertControllerToText;

	@Before
	public void setUp() throws IOException {
		new ControllerGenerateJava().generate("User", null, "template-controller.txt");
		controllerGeneratorFile = new File("src/main/java/br/com/example/controller/UserController.java");
		convertControllerToText = FileGeneratorTestUtils.convertJavaToText(controllerGeneratorFile, Layers.CONTROLLER, "UserControllerTest.txt");
	}

	@Test
	public void testGenerateService() throws IOException {
		boolean validateFileEquals = FileUtils.contentEquals(convertControllerToText, new File("src/test/resources/templates/java/controller/UserController.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}

	@Test
	public void testValidateFileExists() throws IOException {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		new ControllerGenerateJava().generate("User", null, "template-controller.txt");
		String outPutExpected = "Error: file UserController.java already exists.";
		assertEquals("should be true", outPutExpected.trim(), out.toString().trim());
	}

	@After
	public void tearDown() throws IOException {
		FileGeneratorTestUtils.deleteFileAndDirectory(controllerGeneratorFile, convertControllerToText);
	}

}
