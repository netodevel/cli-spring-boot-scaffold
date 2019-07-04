package br.com.netodevel.command.template;

import br.com.generate.config.jms_aws_sqs.MessageListenerGenerator;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TemplateHandler extends OptionHandler {

    private Logger log = LoggerFactory.getLogger(TemplateHandler.class);

    private OptionSpec<String> template;
    private OptionSpec<Void> listTemplates;

    private List<String> templates = Collections.singletonList("jms-aws-sqs");

    @Override
    protected void options() {
        this.template = option(Arrays.asList("template", "t"), "name of template").withRequiredArg();
        this.listTemplates = option(Arrays.asList("list"), "list of available templates");
    }

    @Override
    protected ExitStatus run(OptionSet options) {
        String template = (String) options.valueOf("t");

        if (templateNotExists(template)) return ExitStatus.ERROR;
        if (options.has(this.listTemplates)) output();

        return executeTemplate(template);
    }

    private ExitStatus executeTemplate(String template) {
        System.out.println("Generate config to: ".concat(template));
        if (template.equals("jms-aws-sqs")) {
            try {
                new MessageListenerGenerator().generateConfig("MessageListener", "jms_aws_sqs/template-message-listener.txt");
            } catch (IOException e) {
                return ExitStatus.ERROR;
            }
        }
        return ExitStatus.OK;
    }

    private boolean templateNotExists(String template) {
        if (template != null && !template.isEmpty()) {
            if (!templates.contains(template)) {
                System.out.println("template ".concat(template).concat(" not found. Use --list to see available template"));
                return true;
            }
        }
        return false;
    }

    private void output() {
        System.out.println("Templates available");
        System.out.println("* jms-aws-sqs");
    }
}
