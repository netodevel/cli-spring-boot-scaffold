package br.com.netodevel.generator;

import br.com.netodevel.commons.validator.TextHelper;

public class GenerateValidator {

    public static void validate(GeneratorModel generatorModel) {
        if (TextHelper.isNullOrEmpty(generatorModel.getPathFile())) throw new IllegalArgumentException("path file can not be null");
    }

    public static void validateDeps(Generator generator) {
        if (generator.getFileHelper() == null) throw new IllegalArgumentException("FileHelper can not be null");
    }

}
