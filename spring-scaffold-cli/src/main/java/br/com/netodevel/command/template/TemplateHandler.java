package br.com.netodevel.command.template;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.util.Arrays;

public class TemplateHandler extends OptionHandler {

    private OptionSpec<String> template;

    @Override
    protected void options() {
        this.template = option(Arrays.asList("template", "t"), "name of template").withRequiredArg();
    }

    @Override
    protected ExitStatus run(OptionSet options) {
        String templateName = (String) options.valueOf("n");

        System.out.println("Your Template Name");
        return ExitStatus.OK;
    }
}
