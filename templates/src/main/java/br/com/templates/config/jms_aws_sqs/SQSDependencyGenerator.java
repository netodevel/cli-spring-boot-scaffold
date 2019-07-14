package br.com.templates.config.jms_aws_sqs;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SQSDependencyGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public SQSDependencyGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    public File runGenerate() throws IOException {
        String dependency = "\n" +
                "    <dependency>\n" +
                "        <groupId>org.springframework.cloud</groupId>\n" +
                "        <artifactId>spring-cloud-aws-messaging</artifactId>\n" +
                "        <version>2.1.1.RELEASE</version>\n" +
                "    </dependency>\n" +
                "    <dependency>\n" +
                "        <groupId>org.springframework.cloud</groupId>\n" +
                "        <artifactId>spring-cloud-starter-aws</artifactId>\n" +
                "        <version>2.1.1.RELEASE</version>\n" +
                "    </dependency>\n" +
                "</dependencies>";

        Map<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("</dependencies>", dependency);
        this.generatorOptions.setKeyValue(keyValue);
        this.generatorOptions.setName("pom.xml");

        return addDependency(this.generatorOptions);
    }

    @Override
    public void output(String pathPackage, String filename) {
        System.out.println("Add dependencies in ".concat(pathPackage.concat(filename)));
    }

}
