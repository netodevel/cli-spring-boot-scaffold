package br.com.templates.config.jms_aws_sqs;

import br.com.generator.core.GeneratorOptions;
import br.com.templates.helper.LoadTemplateTester;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SQSDependencyGeneratorTest {

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
    public void shouldCreateFile() throws IOException, URISyntaxException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath().concat("/pom.xml"));
        generatorOptions.setTemplatePath(getClass().getResource("/templates/config/template-pom.xml").toURI().getPath());

        SQSDependencyGenerator sqsDependencyGenerator = new SQSDependencyGenerator(generatorOptions);

        File file = sqsDependencyGenerator.runGenerate();

        assertTrue(file.exists());
    }

    @Test
    @Ignore
    public void shouldReturnContent() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());
        generatorOptions.setTemplatePath("/templates/config/template-pom.xml");

        SQSDependencyGenerator sqsDependencyGenerator = new SQSDependencyGenerator(generatorOptions);
        File file = sqsDependencyGenerator.runGenerate();

        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/template-pom-test.xml");

        assertEquals(contentExpected.replace(" ", "").trim(), contentReturned.replace(" ", "").trim());
    }

}