package br.com.netodevel.commons.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TextHelperTest {

    @Test
    public void whenValueIsNullShouldReturnTrue() {
        TextHelper textHelper = new TextHelper();
        Boolean valid = textHelper.isNullOrEmpty(null);
        assertTrue(valid);
    }

    @Test
    public void whenValueIsEmptyShouldReturnTrue() {
        TextHelper textHelper = new TextHelper();
        Boolean valid = textHelper.isNullOrEmpty("");
        assertTrue(valid);
    }

    @Test
    public void whenValueIsValidShouldReturnFalse() {
        TextHelper textHelper = new TextHelper();
        Boolean valid = textHelper.isNullOrEmpty("fake_value");
        assertFalse(valid)
        ;
    }

}
