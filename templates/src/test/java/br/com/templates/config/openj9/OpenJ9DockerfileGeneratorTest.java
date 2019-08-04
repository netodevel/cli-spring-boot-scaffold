package br.com.templates.config.openj9;

import br.com.generator.core.GeneratorOptions;
import br.com.templates.helper.LoadTemplateTester;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class OpenJ9DockerfileGeneratorTest {

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

        OpenJ9DockerfileGenerator entryPointMessageGenerator = new OpenJ9DockerfileGenerator(generatorOptions);
        File file = entryPointMessageGenerator.runGenerate();
        assertTrue(file.exists());
    }

    @Test
    public void shouldReturnContent() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        OpenJ9DockerfileGenerator entryPointMessageGenerator = new OpenJ9DockerfileGenerator(generatorOptions);
        File file = entryPointMessageGenerator.runGenerate();

        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/openj9/dockerfile-template-test.txt");

        assertEquals(contentExpected, contentReturned);
    }
}