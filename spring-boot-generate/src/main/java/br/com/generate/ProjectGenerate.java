package br.com.generate;

import br.com.attributes.Project;
import br.com.util.DirectorysLinux;
import br.com.util.DirectorysWindows;
import org.apache.commons.lang.SystemUtils;
import java.io.File;
import java.nio.file.Paths;

public class ProjectGenerate {
	
	public ProjectGenerate(String nameProject, String database) {
		generate(nameProject, database);
	}

	public boolean generate(String nameProject, String database) {
		String baseDirProject = null;
		String currentLocation = null;

		if (SystemUtils.IS_OS_LINUX) {
			currentLocation = Paths.get(".").toAbsolutePath().toString();
			baseDirProject = currentLocation + "//" + nameProject;
		} else if (SystemUtils.IS_OS_WINDOWS) {
			currentLocation = System.getProperty("user.dir");
			baseDirProject = currentLocation + "\\" + nameProject;
		}
		boolean project = new File(baseDirProject).mkdir();
		return generateProject(nameProject, baseDirProject, project, database);
	}

	private boolean generateProject(String nameProject, String baseDirProject, boolean project, String database) {
		if (project) {

			Project projectGenerate = null;
			if (SystemUtils.IS_OS_WINDOWS) {
				projectGenerate = new Project(DirectorysWindows.SRC_MAIN_JAVA, DirectorysWindows.SRC_MAIN_RESOURCES, DirectorysWindows.SRC_TEST_JAVA, DirectorysWindows.SRC_TEST_RESOURCES, DirectorysWindows.TARGET);
			} else if (SystemUtils.IS_OS_LINUX) {
				projectGenerate = new Project(DirectorysLinux.SRC_MAIN_JAVA, DirectorysLinux.SRC_MAIN_RESOURCES, DirectorysLinux.SRC_TEST_JAVA, DirectorysLinux.SRC_TEST_RESOURCES, DirectorysLinux.TARGET);
			}

			/**
			 * src/main/java
			 */
			Boolean dirJavaSoruces = new File(baseDirProject + projectGenerate.getSrcMainJava()).mkdirs();
			if (dirJavaSoruces) { System.out.println("src\\main\\java created"); }

			/**
			 * src/main/resources
			 */
			Boolean dirJavaResources = new File(baseDirProject + projectGenerate.getSrcMainResources()).mkdirs();
			if (dirJavaResources) { System.out.println("src\\main\\resources created");  }

			/**
			 * src/test/java
			 */
			Boolean dirTestJavaSources = new File(baseDirProject + projectGenerate.getSrcTestJava()).mkdirs();
			if (dirTestJavaSources) { System.out.println("src\\test\\java created"); }


			/**
			 * src/test/resources
			 */
			Boolean dirTestResouces = new File(baseDirProject + projectGenerate.getSrcTestResources()).mkdirs();
			if (dirTestResouces) { System.out.println("src\\test\\resources created"); }

			/**
			 * target
			 */
			Boolean dirTarget = new File(baseDirProject + projectGenerate.getTarget()).mkdir();
			if (dirTarget) { System.out.println("\\target created"); }

			/**
			 * Pom Generate
			 */
			PomGenerate pomGenerate = new PomGenerate();
			pomGenerate.generate(baseDirProject, nameProject, database);

			/**
			 * application.properties generate
			 */
			ApplicationPropertiesGenerate applicationPropertiesGenerate = new ApplicationPropertiesGenerate();
			applicationPropertiesGenerate.generate(baseDirProject, database);

			/**
			 * Scaffold.info
			 */
			ScaffoldInfoGenerate scaffoldInfoGenerate = new ScaffoldInfoGenerate();
			scaffoldInfoGenerate.generate(baseDirProject);

			/**
			 * MainApplicationRUN
			 */
			MainGenerate mainGenerate = new MainGenerate();
			mainGenerate.generate(baseDirProject);

			System.out.println(ColorsConsole.ANSI_GREEN +"created projectGenerate successful");
			return true;
		} else {
			System.out.println(ColorsConsole.ANSI_RED + "project already exists");
			return false;
		}
	}

}
