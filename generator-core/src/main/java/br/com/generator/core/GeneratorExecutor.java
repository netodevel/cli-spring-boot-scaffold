package br.com.generator.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GeneratorExecutor {

    private EngineContract templateEngine;

    public GeneratorExecutor(EngineContract templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generate(GeneratorOptions options) throws IOException {
        String contentTemplate = loadTemplate(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());

        File fileGenerated = new File(options.getDestination().concat("/").concat(options.getName()));
        FileUtils.writeStringToFile(fileGenerated, contentReplaced);

        return fileGenerated;
    }

    public File addDependecies(GeneratorOptions options) throws IOException {
        String contentTemplate = loadPom(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());

        File fileGenerated = new File(options.getDestination());
        FileUtils.writeStringToFile(fileGenerated, contentReplaced);

        return fileGenerated;
    }

    public String loadTemplate(String templatePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(templatePath);
        return IOUtils.toString(in, "UTF-8");
    }

    public String loadPom(String pomPath) throws IOException {
        File file = new File(pomPath);
        InputStream in = new FileInputStream(file);
        return IOUtils.toString(in, "UTF-8");
    }

}
