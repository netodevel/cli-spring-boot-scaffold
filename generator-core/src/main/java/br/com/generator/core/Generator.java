package br.com.generator.core;

import java.io.File;
import java.io.IOException;

public abstract class Generator implements GeneratorContract {

    private GeneratorExecutor generator;
    private GeneratorOptions generatorOptions;

    public Generator() {
        generator = new GeneratorExecutor(new TemplateEngine());
    }

    public File generate(GeneratorOptions generatorOptions) throws IOException {
        this.generatorOptions = generatorOptions;
        return generator.generate(generatorOptions);
    }

    public File addDependency(GeneratorOptions generatorOptions) throws IOException {
        return generator.addDependecies(generatorOptions);
    }

    public File addProperties(GeneratorOptions generatorOptions) throws IOException {
        return generator.addProperties(generatorOptions);
    }

    public void output(String pathPackage, String filename) {
        System.out.println("created ".concat(pathPackage.concat(filename)));
    }

    public GeneratorOptions getGeneratorOptions() {
        return generatorOptions;
    }
}
