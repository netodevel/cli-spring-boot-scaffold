package br.com.netodevel.command.template;

import br.com.generate.helpers.ScaffoldInfoHelper;
import br.com.generator.core.GeneratorOptions;
import br.com.templates_java.ComposeTemplate;
import br.com.templates_java.config.jms_aws_sqs.EntryPointMessageGenerator;
import br.com.templates_java.config.jms_aws_sqs.MessageListenerGenerator;
import br.com.templates_java.config.jms_aws_sqs.SQSDependencyGenerator;
import br.com.templates_java.config.jms_aws_sqs.SQSPropertiesGenerator;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class TemplateHandler extends OptionHandler {

    private List<String> templates = Collections.singletonList("jms-aws-sqs");

    private OptionSpec<String> template;
    private OptionSpec<Void> listTemplates;

    private ScaffoldInfoHelper scaffoldInfo;

    public TemplateHandler() {
    }

    public TemplateHandler(ScaffoldInfoHelper scaffoldInfoHelper) {
        this.scaffoldInfo = scaffoldInfoHelper;
    }

    @Override
    public void options() {
        this.template = option(asList("template", "t"), "name of template").withRequiredArg();
        this.listTemplates = option(asList("list"), "list of available templates");
    }

    @Override
    protected ExitStatus run(OptionSet options) {
        String template = (String) options.valueOf("t");

        if (templateNotExists(template)) return ExitStatus.ERROR;
        if (options.has(this.listTemplates)) output();

        if (options.has(this.template)) return executeTemplate(template);
        return ExitStatus.ERROR;
    }

    private ExitStatus executeTemplate(String template) {
        System.out.println("Generate config to: ".concat(template));
        if (template.equals("jms-aws-sqs")) {
            return generateJmsAwsSQS();
        }
        return ExitStatus.OK;
    }

    private ExitStatus generateJmsAwsSQS() {
        try {
            GeneratorOptions generatorOptions = new GeneratorOptions();
            generatorOptions.setDestination(scaffoldInfo.getPathPackage().concat("consumer"));
            HashMap<String, String> keyValues = new HashMap<String, String>();
            keyValues.put("${package}", scaffoldInfo.getPackage().concat(".consumer"));
            generatorOptions.setKeyValue(keyValues);

            GeneratorOptions sqsDependencyOptions = new GeneratorOptions();
            sqsDependencyOptions.setTemplatePath(scaffoldInfo.getPomPath());
            sqsDependencyOptions.setDestination(scaffoldInfo.getPomDest());

            GeneratorOptions sqsPropertyOptions = new GeneratorOptions();
            sqsPropertyOptions.setTemplatePath(scaffoldInfo.getApplicationProperties());
            sqsPropertyOptions.setDestination(scaffoldInfo.getApplicationPropertiesDest());

            ComposeTemplate.runAll(scaffoldInfo.getPathPackage(),
                    asList(new MessageListenerGenerator(generatorOptions), new EntryPointMessageGenerator(generatorOptions),
                            new SQSDependencyGenerator(sqsDependencyOptions), new SQSPropertiesGenerator(sqsPropertyOptions)));

        } catch (IOException | URISyntaxException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
            return ExitStatus.ERROR;
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
