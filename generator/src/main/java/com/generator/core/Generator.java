package com.generator.core;

public interface Generator {

    boolean generate(GeneratorModel generatorMode);
    String templatePath();
    String replaceAll(GeneratorModel generatorModel);
}
