package br.com.netodevel.command.template;

import br.com.netodevel.exceptions.ValidatorException;

public class TemplateValidator {

    public static void validateCommand(String argument, String message) {
        if (argument == null || argument.isEmpty()) throw new ValidatorException(message);
    }
}
