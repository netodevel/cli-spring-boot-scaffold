package br.com.netodevel.commons.validator;

import br.com.netodevel.commons.exception.CommonsException;
import br.com.netodevel.commons.io.FileHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileHelperTest {

    @Test
    public void givenFileWhenReadShouldReturnStringContent() {
        String path = "templates/hello-world-template.txt";
        String content = new FileHelper().readTemplateToString(path);
        assertEquals("Hello World", content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenPathNullShouldReturnIllegalException() {
        new FileHelper().readTemplateToString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenPathIsEmptyShouldReturnIllegalException() {
        new FileHelper().readTemplateToString("");
    }

    @Test(expected = CommonsException.class)
    public void givenPathInvalidShouldReturnCommonsExectpion() {
        new FileHelper().readTemplateToString("fake_value");
    }

}
