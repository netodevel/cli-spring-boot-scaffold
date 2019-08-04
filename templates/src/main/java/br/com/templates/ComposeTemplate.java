package br.com.templates;

import br.com.generator.core.Generator;

import java.io.IOException;
import java.util.List;

public class ComposeTemplate {

    public static void runAll(String pathPackage, List<Generator> generators) throws IOException {
        for (Generator generator : generators) {
            generator.runGenerate();
        }
    }

}
