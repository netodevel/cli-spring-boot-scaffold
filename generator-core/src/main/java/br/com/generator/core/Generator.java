package br.com.generator.core;

import java.io.File;
import java.io.IOException;

public abstract class Generator implements GeneratorContract {

    private GeneratorExecutor generator;

    public Generator() {
        generator = new GeneratorExecutor(new TemplateEngine());
    }

    public File generate(GeneratorOptions generatorOptions) throws IOException {
        return generator.generate(generatorOptions);
    }
}
