package br.com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.generate.ProjectGenerate;

public class ProjectGenerateTest {

	private ProjectGenerate projectGenerate;
	private String nameProject = "testProject";
	private String currentLocation; 
	private String baseDirProject; 
	
	@Before
	public void setUp() {
		projectGenerate = new ProjectGenerate(nameProject);
		currentLocation = System.getProperty("user.dir"); 
		baseDirProject = currentLocation + "\\" + nameProject;
	}
	
	@Test
	public void testCreatedProject() {
		File project = new File(baseDirProject);
		Assert.assertTrue(project.exists());
	}
	
	@Test
	public void testCreatedProjectAlreadyExists() {
		Assert.assertFalse(projectGenerate.generate(nameProject));
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
