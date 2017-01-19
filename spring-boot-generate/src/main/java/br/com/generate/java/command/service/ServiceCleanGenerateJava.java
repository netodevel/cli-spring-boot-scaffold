package br.com.generate.java.command.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.generate.IBaseGenerateClean;
import br.com.genereate.scaffoldinfo.command.ReadScaffoldInfo;

public class ServiceCleanGenerateJava extends ReadScaffoldInfo implements IBaseGenerateClean {

	public ServiceCleanGenerateJava(String className) {
		generate(className);
	}
	
	@Override
	public void generate(String nameClass) {
		if (validateFile(nameClass) && getSetupDone()) {
			PrintWriter writer = null;
			try {
				File file = new File(getPathPackage() + "service/" + nameClass + "Service.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer);
				writer.println("");
				writer.println("@Service");
				writer.println("@Transactional(readOnly = true)");
				writer.println("public class " + nameClass + "Service {");
				writer.println("");
				writer.println("");
				writer.println("}");
				writer.close();
				System.out.println("create " + getPathPackage() + "service/" + nameClass + "Service.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print) {
		print.println("package " + getPackage() + ".service" + ";");
		print.println("import org.springframework.stereotype.Service;");
		print.println("import org.springframework.transaction.annotation.Transactional;");
	}


	@Override
	public boolean validateFile(String nameFile) {
		File f = new File(getPathPackage() + "service/" + nameFile + "Service.java");
		if(f.exists()) { 
			System.out.println(nameFile + "Service already exists!");
			return false;
		} else {
			return true;
		}
	}
	
}
