package br.com.command.scaffold;

import br.com.generate.helpers.ScaffoldInfoHelper;
import br.com.generate.source.controller.ControllerGenerator;
import br.com.generate.source.model.ModelGenerator;
import br.com.generate.source.repository.RepositoryGenerator;
import br.com.generate.source.service.ServiceGenerator;
import br.com.generate.thymeleaf.ThymeleafGenerator;
import br.com.generator.core.GeneratorOptions;
import br.com.templates.entity.EntityCache;
import br.com.templates.entity.EntityExecutor;
import br.com.templates.entity.EntityGenerator;
import br.com.templates.entity.LombokDependencyGenerator;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScaffoldHandler extends OptionHandler {

    @SuppressWarnings("unused")
    private OptionSpec<String> nameEntity;

    @SuppressWarnings("unused")
    private OptionSpec<String> parametersEntity;

    @SuppressWarnings("unused")
    private OptionSpec<String> language;

    private ScaffoldInfoHelper scaffoldInfoHelper;

    public ScaffoldHandler(ScaffoldInfoHelper scaffoldInfoHelper) {
        this.scaffoldInfoHelper = scaffoldInfoHelper;
    }

    @Override
    protected void options() {
        this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity to generate scaffold").withRequiredArg();
        this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameter of entity to generate scaffold").withRequiredArg();
    }

    @Override
    protected ExitStatus run(OptionSet options) throws Exception {
        String nameClass = (String) options.valueOf("n");
        String parametersClass = (String) options.valueOf("p");
        generateJava(nameClass.trim(), parametersClass);
        return ExitStatus.OK;
    }

    private void generateJava(String nameClass, String parametersClass) throws IOException {
        generateScaffoldJava(nameClass, parametersClass);
    }

    private void generateScaffoldJava(String nameClass, String parametersClass) throws IOException {
        try {
            generateModelJava(nameClass, parametersClass);
            new RepositoryGenerator().generate(nameClass, null, "template-repository.txt");
            new ServiceGenerator().generate(nameClass, null, "template-service.txt");
            new ControllerGenerator().generate(nameClass, null, "template-controller.txt");
            new ThymeleafGenerator(nameClass, parametersClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateModelJava(String nameClass, String parameters) throws IOException {
        EntityExecutor entityExecutor = new EntityExecutor();
        entityExecutor.run(nameClass, parameters);

        lombokGenerate();

        for (EntityCache entity : entityExecutor.getEntities()) {
            GeneratorOptions generatorOptions = new GeneratorOptions();
            generatorOptions.setName(entity.getName().concat(".java"));
            generatorOptions.setDestination(scaffoldInfoHelper.getPathPackage().concat("models"));

            Map<String, String> keyValue = new HashMap<>();
            keyValue.put("${content}", entity.getContent());
            keyValue.put("${package}", scaffoldInfoHelper.getPackage().concat(".models"));

            generatorOptions.setKeyValue(keyValue);

            EntityGenerator entityGenerator = new EntityGenerator(generatorOptions);
            entityGenerator.runGenerate();
        }

    }

    private void lombokGenerate() throws IOException {
        GeneratorOptions lombokDepsOptions = new GeneratorOptions();
        lombokDepsOptions.setTemplatePath(scaffoldInfoHelper.getPomPath());
        lombokDepsOptions.setDestination(scaffoldInfoHelper.getPomDest());

        LombokDependencyGenerator lombokDependencyGenerator = new LombokDependencyGenerator(lombokDepsOptions);
        lombokDependencyGenerator.runGenerate();
    }

}
