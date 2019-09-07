package br.com.templates.liquibase;

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
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class LiquibaseGeneratorTest {

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
    @Ignore
    public void shouldCreateFile() throws IOException {
        GeneratorOptions generatorOptions = new GeneratorOptions();
        generatorOptions.setDestination(temporaryPath.getAbsolutePath());

        LiquibaseExecutor liquibaseExecutor = new LiquibaseExecutor();
        HashMap<String, String> keyValue = new HashMap<>();

        keyValue.put("${changeset_number}", "01");
        keyValue.put("${entity_name}", "user");
        keyValue.put("${columns}", liquibaseExecutor.generateColumns("User", "name:String age:Int created:Date"));

        generatorOptions.setKeyValue(keyValue);
        generatorOptions.setName("01-create-table-user.xml");

        LiquibaseGenerator liquibaseGenerator =
                new LiquibaseGenerator(generatorOptions);

        File file = liquibaseGenerator.runGenerate();
        String contentReturned = FileUtils.readFileToString(file);
        String contentExpected = loadTemplateTester.loadTemplate("/templates/config/template-liquibase-test.txt");

        assertEquals(contentExpected.trim(), contentReturned.trim());
    }

}