package br.com.templates_java.config.openj9;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class OpenJ9DockerfileGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public OpenJ9DockerfileGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates/config/openj9/dockerfile-template.txt");
        this.generatorOptions.setName("Dockerfile");
        return generate(this.generatorOptions);
    }

}
