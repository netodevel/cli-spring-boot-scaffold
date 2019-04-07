package br.com.netodevel.commons.validator;

public class TextHelper {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.replace(" ", "").isEmpty();
    }
}
