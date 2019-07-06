package br.com.generator.core;

import java.io.File;
import java.io.IOException;

public interface GeneratorContract {

    File runGenerate(GeneratorOptions generatorOptions) throws IOException;
}
