package br.com.generator.core;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneratorExecutorTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryPath;

    @Before
    public void setUp() throws IOException {
        temporaryPath = temporaryFolder.newFolder("templates-test");
    }

    @Test
    public void shouldReturnFileGenerator() throws IOException {
        GeneratorExecutor generatorExecutor = new GeneratorExecutor(new TemplateEngine());
        String templateFile = "/templates/test-template.txt";

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${key}", "custom value");

        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setTemplatePath(templateFile);
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());
        generatorOptions.setKeyValue(keyValue);
        generatorOptions.setName("my-file.txt");

        File file = generatorExecutor.generate(generatorOptions);
        assertTrue(file.exists());
    }

    @Test
    public void shouldReturnCustomValue() throws IOException {
        GeneratorExecutor generatorExecutor = new GeneratorExecutor(new TemplateEngine());
        String templateFile = "/templates/test-template.txt";

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${key}", "custom value");

        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setTemplatePath(templateFile);
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());
        generatorOptions.setKeyValue(keyValue);
        generatorOptions.setName("my-file.txt");

        File file = generatorExecutor.generate(generatorOptions);
        String content = FileUtils.readFileToString(file);

        assertEquals("custom value", content);
    }

}

