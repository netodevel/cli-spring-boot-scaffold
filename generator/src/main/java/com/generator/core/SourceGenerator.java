package com.generator.core;

public abstract class SourceGenerator implements Generator {

    public boolean generate(GeneratorModel generatorModel) {
        System.out.println("path: " + templatePath());
        System.out.println("replaceAll: " + replaceAll(generatorModel));
        return true;
}

}
