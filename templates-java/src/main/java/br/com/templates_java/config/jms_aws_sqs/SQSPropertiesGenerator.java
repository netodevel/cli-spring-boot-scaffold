package br.com.templates_java.config.jms_aws_sqs;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class SQSPropertiesGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public SQSPropertiesGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    public File runGenerate() throws IOException {
        this.generatorOptions.setProperties(
                "\ncloud.aws.credentials.accessKey=xxxxxx\n" +
                "cloud.aws.credentials.secretKey=xxxxxx\n" +
                "cloud.aws.region.static=us-east-1\n" +
                "cloud.aws.stack.auto=false\n" +
                "cloud.aws.sqs.queue-name=my-queue.fifo");
        this.generatorOptions.setName("application.properties");
        return addProperties(this.generatorOptions);
    }

    @Override
    public void output(String pathPackage, String filename) {
        System.out.println("Add properties in ".concat(pathPackage.concat(filename)));
    }

}
