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

	public ScaffoldInfoGenerate(String...params) {
		generate(params);
	}
	
    @Override
    public void generate(String... params) {
        PrintWriter writer = null;
        try {
            File file = new File(getUserDir() + "/src/main/resources/scaffold.info");
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
            imports(writer, params);
            String namePackage = params[0] != null ? params[0] : "com.example";
            String userDataBase = params[1] != null ? params[1] : "root";
            String passWordDatabase = params[1] != null ? params[1] : "root";
            writer.println("package:" + namePackage);
            writer.println("username:" + userDataBase);
            writer.println("password:" + passWordDatabase);
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
