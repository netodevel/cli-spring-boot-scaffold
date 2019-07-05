package br.com.generator.core;

import br.com.generator.core.exceptions.TemplateEngineException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TemplateEngineTest {

    @Test
    public void shouldReturnHelloWorld() {
        String contentTemplate = "${key}";
        Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put("${key}", "Hello World");

        TemplateEngine templateEngine = new TemplateEngine();
        String expectedValue = templateEngine.replaceValues(contentTemplate, keyValues);

        assertEquals("Hello World", expectedValue);
    }

    @Test(expected = TemplateEngineException.class)
    public void givenContentNull_shouldInvokeException() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.replaceValues(null, null);
    }

}