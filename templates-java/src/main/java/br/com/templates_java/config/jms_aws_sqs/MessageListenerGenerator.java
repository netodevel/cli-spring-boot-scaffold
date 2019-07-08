package br.com.templates_java.config.jms_aws_sqs;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class MessageListenerGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public MessageListenerGenerator() {
    }

    public MessageListenerGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates/config/template-message-listener.txt");
        this.generatorOptions.setName("MessageListener.java");
        return generate(this.generatorOptions);
    }

}
