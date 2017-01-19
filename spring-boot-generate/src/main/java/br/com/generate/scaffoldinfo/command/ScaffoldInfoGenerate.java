package br.com.generate.scaffoldinfo.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseScaffold;

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ScaffoldInfoGenerate extends ReadScaffoldInfo implements IBaseScaffold {

    @Override
    public void generate(String... params) {
        String BASE_DIR = params[0];
        PrintWriter writer = null;
        try {
            File file = new File(BASE_DIR + "/src/main/resources/scaffold.info");
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
            imports(writer, params);
            writer.println("package:br.com.example");
            writer.println("database:mydatabase");
            writer.println("username:root");
            writer.println("password:root");
            writer.close();
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
    	File f = new File(getUserDir() + "/src/main/resources/scaffold.info");
		if(f.exists()) { 
			System.out.println("scaffold.info already exists!");
			return false;
		} else {
			return true;
		}
    }
}
