package br.com.netodevel.generate.test;

import br.com.generate.Layers;
import br.com.generate.java.command.repository.RepositoryGenerator;
import br.com.netodevel.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RepositoryGenerateTest {

    @Test
    public void repositoryGeneratorTest() throws IOException {
        RepositoryGenerator repositoryGenerator = new RepositoryGenerator();
        String javaStrings = repositoryGenerator.readTemplateFile("template-repository.txt");

        String expectedValue = new LoadTemplateHelper().loadDataset(Layers.REPOSITORY, "UserRepository.txt");
        String generatedValue = repositoryGenerator.operationGenerate(javaStrings, "User", "name:String");

        assertEquals(expectedValue, generatedValue);
    }

}
