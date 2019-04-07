package br.com.netodevel.generator;

import java.util.HashMap;

public interface GeneratorContract {

    String pathTemplateFile();

    HashMap<String, String> variables();
}
