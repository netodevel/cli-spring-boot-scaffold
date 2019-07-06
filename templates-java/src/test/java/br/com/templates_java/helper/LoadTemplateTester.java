package br.com.templates_java.helper;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadTemplateTester {

    public String loadTemplate(String templatePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(templatePath);
        String theString = IOUtils.toString(in, "UTF-8");
        return theString;
    }
}
