package br.com.netodevel.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.lang.SystemUtils;

/**
 * @author NetoDevel 
 */
public class ReadScaffoldInfo {
	
	private static final String SRC_MAIN_RESOURCES = "src/main/resources/";

	public FileReader getArq() throws FileNotFoundException{
		return new FileReader(getUserDir() + "/src/main/resources/scaffold.info");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPathPackage() {
		return "src/main/java/" + getPackage().replace(".", "/") + "/";
	}
	
	public String getPathResources() {
		return SRC_MAIN_RESOURCES;
	}
	
	public String getUserDatabase() throws IOException {
		BufferedReader readArq = new BufferedReader(getArq());
		String row = readArq.readLine();
		while (row != null) {
			row = readArq.readLine();
			String [] values = row.split(":");
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
			String [] values = row.split(":");
			if (values[0].equals("dataBaseName")) {
				return values[1];
			}
		}
		return null;
	}
	
	public boolean getSetupDone() {
		File f = new File(getUserDir() + "/src/main/resources/scaffold.info");
		if(f.exists()) { 
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
			String [] values = row.split(":");
			if (values[0].equals("password")) {
				return values[1];
			}
		}
		return null;
	}
	
}