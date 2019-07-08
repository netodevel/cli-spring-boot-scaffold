package br.com.generate.helpers;

import org.apache.commons.lang.SystemUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;


/**
 * @author NetoDevel
 */
public class ScaffoldInfoHelper {

    public ScaffoldInfoHelper() {
    }

    public FileReader getArq() throws FileNotFoundException {
        FileReader arq = new FileReader(getUserDir() + "/src/main/resources/scaffold.info");
        return arq;
    }

    public String getPomPath() {
        return getUserDir().concat("\\pom.xml").replace("\\", "/");
    }

    public String getPomDest() {
        return getUserDir().concat("\\pom.xml").replace("\\", "/");
    }

    public String getUserDir() {
        String currentLocation = null;
        if (SystemUtils.IS_OS_LINUX) {
            currentLocation = Paths.get(".").toAbsolutePath().toString();
        } else if (SystemUtils.IS_OS_WINDOWS) {
            currentLocation = System.getProperty("user.dir");
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            currentLocation = Paths.get(".").toAbsolutePath().toString();
        } else if (SystemUtils.IS_OS_MAC) {
            currentLocation = Paths.get(".").toAbsolutePath().toString();
        }
        return currentLocation;
    }

    public String getPackage() {
        try {
            BufferedReader readArq = new BufferedReader(getArq());
            String row = readArq.readLine();
            String[] valuesPackage = row.split(":");
            return valuesPackage[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPathPackage() {
        String pathPackage = "src/main/java/" + getPackage().replace(".", "/") + "/";
        return pathPackage;
    }

    public String getUserDatabase() throws IOException {
        BufferedReader readArq = new BufferedReader(getArq());
        String row = readArq.readLine();
        while (row != null) {
            row = readArq.readLine();
            String[] values = row.split(":");
            if (values[0].equals("username")) {
                return values[1];
            }
        }
        return null;
    }

    public String getNameDatabase() throws IOException {
        BufferedReader readArq = new BufferedReader(getArq());
        String row = readArq.readLine();
        while (row != null) {
            row = readArq.readLine();
            String[] values = row.split(":");
            if (values[0].equals("dataBaseName")) {
                return values[1];
            }
        }
        return null;
    }

    public boolean getSetupDone() {
        File f = new File(getUserDir() + "/src/main/resources/scaffold.info");
        if (f.exists()) {
            return true;
        } else {
            System.out.println("Error: before execute spring setup:scaffold command");
            return false;
        }
    }

    public String getPassWordDatabase() throws IOException {
        BufferedReader readArq = new BufferedReader(getArq());
        String row = readArq.readLine();
        while (row != null) {
            row = readArq.readLine();
            String[] values = row.split(":");
            if (values[0].equals("password")) {
                return values[1];
            }
        }
        return null;
    }

    public String getSpringVersion() {
        try {
            BufferedReader readArq = new BufferedReader(getArq());
            String row = readArq.readLine();
            while (row != null) {
                row = readArq.readLine();
                String[] values = row.split(":");
                if (values[0].equals("springVersion")) {
                    return values[1];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getApplicationProperties() throws URISyntaxException {
        return getUserDir().concat("/src/main/resources/application.properties");
    }

    public String getApplicationPropertiesDest() throws URISyntaxException {
        return getUserDir().concat("/src/main/resources/application.properties");
    }

}
