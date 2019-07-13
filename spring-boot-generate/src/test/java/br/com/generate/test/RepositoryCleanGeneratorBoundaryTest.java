package br.com.generate.test;

import br.com.generate.Layers;
import br.com.generate.source.repository.RepositoryCleanGenerator;
import br.com.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RepositoryCleanGeneratorBoundaryTest {

	@Test
	public void shouldGenerateRepository() throws IOException {
		RepositoryCleanGenerator repositoryGenerator = new RepositoryCleanGenerator();
		String javaStrings = repositoryGenerator.readTemplateFile("template-clean-repository.txt");

		String expectedValue = new LoadTemplateHelper().loadDataset(Layers.REPOSITORY,"UserCleanRepository.txt");
		String generatedValue = repositoryGenerator.operationGenerate(javaStrings, "User", "name:String");

		assertEquals(expectedValue, generatedValue);
	}

}
