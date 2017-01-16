package br.com.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldInfoGenerate implements IBaseScaffold {

    @Override
    public void generate(String... params) {
        String BASE_DIR = params[0];
        PrintWriter writer = null;
        try {
            File file = new File(BASE_DIR + "/src/main/resources/scaffold.info");
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
            imports(writer, params);
            writer.println("package:");
            writer.println("database:");
            writer.println("username:");
            writer.println("password:");
            writer.close();
            System.out.println("invoke scaffold");
            System.out.println("create /src/main/resources/scaffold.info");
        } catch (FileNotFoundException e) {
        } catch (UnsupportedEncodingException e) {
        }
    }

    @Override
    public void imports(PrintWriter print, String[] namesClass) {

    }

    @Override
    public String generateParams(String params) {
        return null;
    }

    @Override
    public boolean validateFile(String nameFile) {
        return false;
    }
}
