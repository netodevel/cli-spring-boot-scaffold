package br.com.netodevel.commons.io;

import br.com.netodevel.commons.exception.CommonsException;
import br.com.netodevel.commons.validator.TextHelper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class FileHelper {

    private static final String FIRST_CHARACTER_CONVERTION = "/";

    public String readTemplateToString(String path) {
        if (TextHelper.isNullOrEmpty(path)) throw new IllegalArgumentException("path can not be null");

        InputStream in = getClass().getResourceAsStream(FIRST_CHARACTER_CONVERTION.concat(path));
        if (in == null) throw new CommonsException("could not read file in path: ".concat(path));

        String theString = null;
        try {
            theString = IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            throw new CommonsException("error reading file contents");
        }
        return theString;
    }
}
