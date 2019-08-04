package br.com.templates.entity;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LombokDependencyGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public LombokDependencyGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    public File runGenerate() throws IOException {
        String dependency = "\n" +
                "    <dependency>\n" +
                "        <groupId>org.projectlombok</groupId>\n" +
                "        <artifactId>lombok</artifactId>\n" +
                "        <scope>provided</scope>\n" +
                "    </dependency>\n" +
                "</dependencies>";

        Map<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("</dependencies>", dependency);
        this.generatorOptions.setKeyValue(keyValue);
        this.generatorOptions.setName("pom.xml");
        this.generatorOptions.setDependencies(Collections.singletonList("org.projectlombok"));

        return addDependency(this.generatorOptions);
    }

}
