package br.com.generate.test;

import br.com.generate.Layers;
import br.com.generate.source.controller.ControllerGenerator;
import br.com.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ControllerGenerateTest {

    @Test
    public void shouldGenerateController() throws IOException {
        ControllerGenerator controllerGenerator = new ControllerGenerator();
        String javaStrings = controllerGenerator.readTemplateFile("template-controller.txt");

        String expectedValue = new LoadTemplateHelper().loadDataset(Layers.CONTROLLER, "UserController.txt");
        String generatedValue = controllerGenerator.operationGenerate(javaStrings, "User", "name:String");

        assertEquals(expectedValue, generatedValue);
    }

}
