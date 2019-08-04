package br.com.command.model;

import br.com.generate.helpers.ScaffoldInfoHelper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ModelHandlerTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File temporaryPath;

    @Before
    public void setUp() throws IOException {
        temporaryPath = temporaryFolder.newFolder("test-path");
    }

    @Test
    public void shouldReturnOk() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        Mockito.when(scaffoldInfoHelper.getPackage()).thenReturn("com.example");
        Mockito.when(scaffoldInfoHelper.getPathPackage()).thenReturn(temporaryPath.getAbsolutePath().concat("\\com\\example\\"));
        Mockito.when(scaffoldInfoHelper.getPomPath()).thenReturn(getClass().getResource("/templates/template-fake-pom.xml").toURI().getPath());
        Mockito.when(scaffoldInfoHelper.getPomDest()).thenReturn(temporaryPath.getAbsolutePath().concat("/pom.xml"));

        ModelHandler modelHandler = new ModelHandler(scaffoldInfoHelper);
        ExitStatus exitStatus = modelHandler.run("-n", "User", "-p", "name:String Foo:references(relation:hasMany, name:String)");
        assertEquals(ExitStatus.OK, exitStatus);
    }

    @Test
    public void givenNoParameters_shouldReturnError() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        ModelHandler modelHandler = new ModelHandler(scaffoldInfoHelper);
        ExitStatus exitStatus = modelHandler.run("-n", "USer");
        assertEquals(ExitStatus.ERROR, exitStatus);
    }

    @Test
    public void givenNoClass_shouldReturnError() throws Exception {
        ScaffoldInfoHelper scaffoldInfoHelper = mock(ScaffoldInfoHelper.class);

        ModelHandler modelHandler = new ModelHandler(scaffoldInfoHelper);
        ExitStatus exitStatus = modelHandler.run("-p", "foo:String");
        assertEquals(ExitStatus.ERROR, exitStatus);
    }

}