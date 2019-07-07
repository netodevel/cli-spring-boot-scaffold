package br.com.templates_java;

import br.com.generator.core.Generator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ComposeTemplate {

    public static void runAll(String pathPackage, List<Generator> generators) throws IOException {
        for (Generator generator : generators) {
            File fileCreated = generator.runGenerate(generator.getGeneratorOptions());
            generator.output(pathPackage, fileCreated.getName());
        }
    }

}
