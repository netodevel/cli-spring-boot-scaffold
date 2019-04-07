package br.com.netodevel.generator;

import java.util.HashMap;

public class GeneratorModel {

    private String pathFile;
    private HashMap<String, String> variables;

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public HashMap<String, String> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, String> variables) {
        this.variables = variables;
    }
}
