package br.com.netodevel.generator;

import br.com.netodevel.commons.io.FileHelper;

import java.util.Map;

public class Generator {

    private FileHelper fileHelper;

    public String generateContent(GeneratorModel generatorModel) {
        GenerateValidator.validate(generatorModel);
        GenerateValidator.validateDeps(this);

        String contentString = this.fileHelper.readTemplateToString(generatorModel.getPathFile());

        for (Map.Entry<String, String> variable : generatorModel.getVariables().entrySet()) {
            if (contentString.contains(variable.getKey())) {
                contentString = contentString.replace(variable.getKey(), variable.getValue());
            }
        }
        return contentString;
    }

    public void setFileHelper(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    protected FileHelper getFileHelper() {
        return fileHelper;
    }

}
