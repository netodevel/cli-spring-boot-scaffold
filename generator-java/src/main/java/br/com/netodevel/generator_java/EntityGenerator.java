package br.com.netodevel.generator_java;

import br.com.netodevel.generator.Generator;
import br.com.netodevel.generator.GeneratorModel;

public class EntityGenerator {

    private Generator generator;

    public String generate(GeneratorModel generatorModel) {
        return this.generator.generateContent(generatorModel);
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }
}
