package br.com.generate.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadTemplateHelper {

    public String loadDataset(String layer, String fileNameTemplate) throws IOException {
        InputStream in = getClass().getResourceAsStream("/templates/java/" + layer + "/" + fileNameTemplate);
        String theString = IOUtils.toString(in, "UTF-8");
        return theString;
    }

}
