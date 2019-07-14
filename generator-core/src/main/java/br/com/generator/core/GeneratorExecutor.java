package br.com.generator.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class GeneratorExecutor {

    private EngineContract templateEngine;

    public GeneratorExecutor(EngineContract templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generate(GeneratorOptions options) throws IOException {
        String contentTemplate = loadTemplate(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());
        File fileGenerated = new File(options.getDestination().concat("/").concat(options.getName()));

        if (fileGenerated.exists())
            System.out.println("INFO ".concat(options.getDestination().concat("/").concat(options.getName())).concat(" already exists"));
        if (!fileGenerated.exists()) {
            FileUtils.writeStringToFile(fileGenerated, contentReplaced);
            System.out.println("CREATED ".concat(options.getDestination().concat("/").concat(options.getName())));
        }

        return fileGenerated;
    }

    public File addDependecies(GeneratorOptions options) throws IOException {
        String contentTemplate = loadPom(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());

        File fileGenerated = new File(options.getDestination());
        FileUtils.writeStringToFile(fileGenerated, contentReplaced);

        System.out.println("Add dependencies in ".concat(options.getName()));
        return fileGenerated;
    }

    public File addMavenPlugin(GeneratorOptions options) throws IOException {
        String contentTemplate = loadPom(options.getTemplatePath());
        String contentReplaced = templateEngine.replaceValues(contentTemplate, options.getKeyValue());
        String addPluginValues = templateEngine.replaceValues(contentReplaced, options.getPluginValues());

        File fileGenerated = new File(options.getDestination());
        FileUtils.writeStringToFile(fileGenerated, addPluginValues);

        System.out.println("Add maven plugin in ".concat(options.getName()));
        return fileGenerated;
    }

    public File addProperties(GeneratorOptions options) throws IOException {
        File loadFiled = new File(options.getTemplatePath());

        FileWriter fileWritter = new FileWriter(loadFiled, true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(options.getProperties());
        bufferWritter.close();
        fileWritter.close();

        System.out.println("Add properties in ".concat(options.getName()));
        System.out.println("\t".concat(options.getProperties()));

        return loadFiled;
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
