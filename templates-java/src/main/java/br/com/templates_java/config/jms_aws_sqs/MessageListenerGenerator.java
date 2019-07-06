package br.com.templates_java.config.jms_aws_sqs;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class MessageListenerGenerator extends Generator {

    public File runGenerate(GeneratorOptions generatorOptions) throws IOException {
        generatorOptions.setTemplatePath("/templates/config/template-message-listener.txt");
        generatorOptions.setName("MessageListener.java");
        return generate(generatorOptions);
    }

}
