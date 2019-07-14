package br.com.templates_java.config.openj9;

import br.com.generator.core.GeneratorOptions;
import br.com.templates_java.config.jms_aws_sqs.SQSDependencyGenerator;
import br.com.templates_java.helper.LoadTemplateTester;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class OpenJ9MavenPluginGeneratorTest {

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
        Map<String, String> keyValue  = new HashMap<>();
        keyValue.put("${main_class}", "br.com.example.DemoApplication");
        generatorOptions.setKeyValue(keyValue);

        OpenJ9MavenPluginGenerator sqsDependencyGenerator = new OpenJ9MavenPluginGenerator(generatorOptions);

        File file = sqsDependencyGenerator.runGenerate();
        assertTrue(file.exists());
    }

    @Test
    @Ignore
    public void shouldReturnContent() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());
        generatorOptions.setTemplatePath("/templates/config/template-pom.xml");
        Map<String, String> keyValue  = new HashMap<>();
        keyValue.put("${main_class}", "br.com.example.DemoApplication");
        generatorOptions.setKeyValue(keyValue);

        SQSDependencyGenerator sqsDependencyGenerator = new SQSDependencyGenerator(generatorOptions);
        File file = sqsDependencyGenerator.runGenerate();

        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/openj9/template-pom-test.xml");

        assertEquals(contentExpected.replace(" ", "").trim(), contentReturned.replace(" ", "").trim());
    }
}