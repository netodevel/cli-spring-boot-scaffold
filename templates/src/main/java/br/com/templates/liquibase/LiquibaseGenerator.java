package br.com.templates.liquibase;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;

public class LiquibaseGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public LiquibaseGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        this.generatorOptions.setTemplatePath("/templates.liquibase/liquibase-template.xml");
        return generate(this.generatorOptions);
    }

}