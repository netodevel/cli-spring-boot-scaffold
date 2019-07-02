package br.com.netodevel.generate.test;

import br.com.generate.Layers;
import br.com.generate.java.command.repository.RepositoryCleanGenerator;
import br.com.netodevel.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RepositoryCleanGeneratorTest {

	@Test
	public void shouldGenerateRepository() throws IOException {
		RepositoryCleanGenerator repositoryGenerator = new RepositoryCleanGenerator();
		String javaStrings = repositoryGenerator.readTemplateFile("template-clean-repository.txt");

		String expectedValue = new LoadTemplateHelper().loadDataset(Layers.REPOSITORY,"UserCleanRepository.txt");
		String generatedValue = repositoryGenerator.operationGenerate(javaStrings, "User", "name:String");

		assertEquals(expectedValue, generatedValue);
	}

}
