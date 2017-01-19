package br.com.generate.java.command.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseGenerateClean;
import br.com.generate.scaffoldinfo.command.ReadScaffoldInfo;

public class ControllerCleanGenerateJava extends ReadScaffoldInfo implements IBaseGenerateClean {
	
	public ControllerCleanGenerateJava(String className) {
		generate(className);
	}	
	
	@Override
	public void generate(String className) {
		if (validateFile(className) && getSetupDone()) {
			PrintWriter writer = null;
			try {
				File file = new File(getPathPackage() + "controller/" + className + "Controller.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer);
				writer.println("");
				writer.println("@Controller");
				writer.println("public class " + className + "Controller {");
				writer.println("");
				writer.println("");
				writer.println("}");
				writer.close();
				System.out.println("create " + getPathPackage() + "controller/" + className + "Controller.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print) {
		print.println("package " + getPackage() + ".controller" + ";");
		print.println("import org.springframework.stereotype.Controller;");
	}

	@Override
	public boolean validateFile(String className) {
		File f = new File(getPathPackage() + "controller/" + className + "Controller.java");
		if(f.exists()) { 
			System.out.println(className + "Controller already exists!");
			return false;
		} else {
			return true;
		}
	}
	
}
