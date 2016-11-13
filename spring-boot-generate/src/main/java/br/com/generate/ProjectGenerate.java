package br.com.generate;

import java.io.File;

public class ProjectGenerate {
	
	public ProjectGenerate(String optionValue) {
		generate(optionValue);
	}

	public boolean generate(String nameProject) {

		String currentLocation = System.getProperty("user.dir");
		String baseDirProject = currentLocation + "\\" + nameProject;
		boolean project = new File(baseDirProject).mkdir();

		if (project) {

			/**
			 * src/main/java
			 */
			Boolean dirJavaSoruces = new File(baseDirProject + "\\src\\main\\java").mkdirs();
			if (dirJavaSoruces) { System.out.println("src\\main\\java created"); }

			/**
			 * src/main/resources
			 */
			Boolean dirJavaResources = new File(baseDirProject + "\\src\\main\\resources").mkdirs();
			if (dirJavaResources) { System.out.println("src\\main\\resources created");  }

			/**
			 * src/test/java
			 */
			Boolean dirTestJavaSources = new File(baseDirProject + "\\src\\test\\java").mkdirs();
			if (dirTestJavaSources) { System.out.println("src\\test\\java created"); }

			
			/**
			 * src/test/resources
			 */
			Boolean dirTestResouces = new File(baseDirProject + "\\src\\test\\resources").mkdirs();
			if (dirTestResouces) { System.out.println("src\\test\\resources created"); }
			
			/**
			 * target
			 */
			Boolean dirTarget = new File(baseDirProject + "\\target").mkdir();
			if (dirTarget) { System.out.println("\\target created"); }
			
			/**
			 * Pom Generate
			 */
			PomGenerate pomGenerate = new PomGenerate();
			pomGenerate.generate(baseDirProject, nameProject);
			
			/**
			 * application.properties generate
			 */
			ApplicationPropertiesGenerate applicationPropertiesGenerate = new ApplicationPropertiesGenerate();
			applicationPropertiesGenerate.generate(baseDirProject);

			/**
			 * MainApplicationRUN
			 */
			MainGenerate mainGenerate = new MainGenerate();
			mainGenerate.generate(baseDirProject);
			
			System.out.println(ColorsConsole.ANSI_GREEN +"created project successful");
			return true;
		} else {
			System.out.println(ColorsConsole.ANSI_RED + "project already exists");
			return false;
		}
	}

}
