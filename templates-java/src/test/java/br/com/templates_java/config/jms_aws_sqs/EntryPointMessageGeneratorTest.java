package br.com.templates_java.config.jms_aws_sqs;


import br.com.generator.core.GeneratorOptions;
import br.com.templates_java.helper.LoadTemplateTester;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EntryPointMessageGeneratorTest {

    private LoadTemplateTester loadTemplateTester;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryPath;

    @Before
    public void setUp() throws IOException {
        temporaryPath = temporaryFolder.newFolder("test-templates");
        loadTemplateTester = new LoadTemplateTester();
    }

    @Test
    public void shouldCreateFile() throws IOException {

        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${package}", "br.com.example");
        generatorOptions.setKeyValue(keyValue);

        EntryPointMessageGenerator entryPointMessageGenerator = new EntryPointMessageGenerator(generatorOptions);

        File file = entryPointMessageGenerator.runGenerate(generatorOptions);
        assertTrue(file.exists());
    }

    @Test
    public void shouldReturnContent() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        HashMap<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("${package}", "br.com.example");
        generatorOptions.setKeyValue(keyValue);

        EntryPointMessageGenerator entryPointMessageGenerator = new EntryPointMessageGenerator(generatorOptions);
        File file = entryPointMessageGenerator.runGenerate(generatorOptions);

        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/template-entrypoint-listener-test.txt");

        assertEquals(contentExpected, contentReturned);
    }

}