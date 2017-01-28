package br.com.netodevel.generate.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import br.com.generate.java.command.repository.RepositoryGenerateJava;

public class RepositoryGenerateTest {
	
	@Test
	public void testGenerateRepository() throws IOException {
		new RepositoryGenerateJava().generate("User", null, "template-repository.txt");
		File javaTemplateFile = new File("src/main/java/br/com/example/repository/UserRepository.java");
		boolean validateFileEquals = FileUtils.contentEquals(javaTemplateFile, new File("src/test/resources/templates/java/repository/UserRepository.txt"));
		assertEquals("should be true", true, validateFileEquals);
	}
	
	
}
