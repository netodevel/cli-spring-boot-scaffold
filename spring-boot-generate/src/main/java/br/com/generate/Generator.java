package br.com.generate;

import br.com.generate.helpers.ScaffoldInfoHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public abstract class Generator extends ScaffoldInfoHelper implements GeneratorBoundary {

    public String readTemplateFile(String fileNameTemplate) throws IOException {
        InputStream in = getClass().getResourceAsStream("/templates/java/" + getLayer() + "/" + fileNameTemplate);
        String theString = IOUtils.toString(in, "UTF-8");
        return theString;
    }

    public String readConfigTemplate(String pathTemplate) throws IOException {
        InputStream in = getClass().getResourceAsStream("/templates/config/".concat(pathTemplate));
        String theString = IOUtils.toString(in, "UTF-8");
        return theString;
    }

    public void outPutFile(String javaStrings, String fileOutPutName) throws IOException {
        String nameFileOutPut;
        if (getLayer().equals(Layers.MODEL) || getLayer().equals("consumer")) {
            nameFileOutPut = getPathPackage() + getLayer() + "/" + fileOutPutName + ".java";
        } else {
            nameFileOutPut = getPathPackage() + getLayer() + "/" + fileOutPutName + StringUtils.capitalize(getLayer()) + ".java";
        }
        File newJavaFile = new File(nameFileOutPut);
        FileUtils.writeStringToFile(newJavaFile, javaStrings);
        outputCreate(fileOutPutName, getLayer());
    }

    public void outputCreate(String fileOutPutName, String layer) {
        String layerConcat = "";
        if (!layer.equals(Layers.MODEL) && !layer.equals("consumer")) {
            layerConcat = StringUtils.capitalize(getLayer());
        }
        System.out.println("create " + getPathPackage() + getLayer() + "/" + fileOutPutName + layerConcat + ".java");
    }

}
