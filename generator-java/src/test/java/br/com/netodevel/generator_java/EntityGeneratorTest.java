package br.com.netodevel.generator_java;

import br.com.netodevel.commons.io.FileHelper;
import br.com.netodevel.generator.Generator;
import br.com.netodevel.generator.GeneratorModel;
import org.junit.Test;

import java.util.HashMap;

public class EntityGeneratorTest {

    @Test
    public void givenClassNameShouldReturnClass(){
        Generator generator = new Generator();
        generator.setFileHelper(new FileHelper());

        EntityGenerator entityGenerator = new EntityGenerator();
        entityGenerator.setGenerator(generator);

        GeneratorModel generatorModel = new GeneratorModel();
        generatorModel.setPathFile("templates/entity-template.txt");

        HashMap<String, String> variables = new HashMap<String, String>();
        variables.put("${CLASS_NAME}", "User");
        generatorModel.setVariables(variables);

        String contentGenerated = entityGenerator.generate(generatorModel);
        System.out.println(contentGenerated);
    }

}
