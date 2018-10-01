package com.generator.core;

public class SampleGenerator extends SourceGenerator {

    public String replaceAll(GeneratorModel generatorModel) {
        return generatorModel.getClassName();
    }

    public String templatePath() {
        return "/sample-generator.txt";
    }

}
