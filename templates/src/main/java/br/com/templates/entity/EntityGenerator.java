package br.com.templates.entity;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class EntityGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public EntityGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates.entity/entity-template.txt");
        return generate(this.generatorOptions);
    }
}
