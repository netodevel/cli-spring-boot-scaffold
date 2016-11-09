package br.com.generate;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectGenerate {
	
	private static Logger LOGGER = Logger.getLogger(ProjectGenerate.class.getName());

	public ProjectGenerate(String optionValue) {
		generate(optionValue);
	}

	public void generate(String nameProject) {

		String currentLocation = System.getProperty("user.dir");
		String baseDirProject = currentLocation + "\\" + nameProject;
		boolean project = new File(baseDirProject).mkdir();

		if (project) {

			/**
			 * src/main/java
			 */
			Boolean dirJavaSoruces = new File(baseDirProject + "\\src\\main\\java").mkdirs();
			if (dirJavaSoruces) { LOGGER.info("src\\main\\java created"); }

			/**
			 * src/main/resources
			 */
			Boolean dirJavaResources = new File(baseDirProject + "\\src\\main\\resources").mkdirs();
			if (dirJavaResources) { LOGGER.info("src\\main\\resources created"); }

			/**
			 * src/test/java
			 */
			Boolean dirTestJavaSources = new File(baseDirProject + "\\src\\test\\java").mkdirs();
			if (dirTestJavaSources) { LOGGER.info("src\\test\\java created"); }

			
			/**
			 * src/test/resources
			 */
			Boolean dirTestResouces = new File(baseDirProject + "\\src\\test\\resources").mkdirs();
			if (dirTestResouces) { LOGGER.info("src\\test\\resources created"); }
			
			/**
			 * target
			 */
			Boolean dirTarget = new File(baseDirProject + "\\target").mkdir();
			if (dirTarget) {	LOGGER.info("\\target created"); }
			
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
			
			LOGGER.info("project created!");
			
		} else {
			System.out.println("failed to created project!");
		}
	}

}
