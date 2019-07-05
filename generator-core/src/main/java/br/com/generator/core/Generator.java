package br.com.generator.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Generator {

    private EngineContract templateEngine;

    public Generator(EngineContract templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generate(GeneratorOptions options) throws IOException {
        String contentTemplate = loadTemplate(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());

        File fileGenerated = new File(options.getDestination().concat("/").concat(options.getName()));
        FileUtils.writeStringToFile(fileGenerated, contentReplaced);

        return fileGenerated;
    }

    public String loadTemplate(String templatePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(templatePath);
        String theString = IOUtils.toString(in, "UTF-8");
        return theString;
    }
}
