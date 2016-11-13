package br.com.test;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;

import br.com.generate.ProjectGenerate;

public class ProjectGenerateTest {

	@SuppressWarnings("unused")
	private ProjectGenerate projectGenerate;
	private String nameProject = "testProject";
	private String currentLocation = System.getProperty("user.dir");
	private String baseDirProject = currentLocation + "\\" + nameProject;
	
	@Before
	public void setUp() {
		projectGenerate = new ProjectGenerate(nameProject);
	}
	
	@Test
	public void testCreatedProject() {
		File project = new File(baseDirProject);
		Assert.assertTrue(project.exists());
	}
	
	@After
	public void tearDown() {
		File project = new File(baseDirProject);
		try {
			FileUtils.deleteDirectory(project);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
