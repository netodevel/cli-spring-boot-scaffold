package br.com.netodevel.generate.test;

import br.com.generate.Layers;
import br.com.generate.source.service.ServiceGenerator;
import br.com.netodevel.generate.utils.LoadTemplateHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ServiceGenerateTest {

    @Test
    public void shouldGeneratorService() throws IOException {
        ServiceGenerator serviceGenerator = new ServiceGenerator();
        String javaStrings = serviceGenerator.readTemplateFile("template-service.txt");

        String expectedValue = new LoadTemplateHelper().loadDataset(Layers.SERVICE, "UserService.txt");
        String generatedValue = serviceGenerator.operationGenerate(javaStrings, "User", "name:String");

        assertEquals(expectedValue, generatedValue);
    }

}
