package br.com.command.model;

import br.com.generate.helpers.ScaffoldInfoHelper;
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

/**
 * @author NetoDevel
 * @since 0.0.1
 */
public class ModelHandler extends OptionHandler {

    @SuppressWarnings("unused")
    private OptionSpec<String> nameEntity;

    @SuppressWarnings("unused")
    private OptionSpec<String> parametersEntity;

    private ScaffoldInfoHelper scaffoldInfoHelper;

    public ModelHandler() {
    }

    public ModelHandler(ScaffoldInfoHelper scaffoldInfoHelper) {
        this.scaffoldInfoHelper = scaffoldInfoHelper;
    }

    @Override
    protected void options() {
        this.nameEntity = option(Arrays.asList("nameEntity", "n"), "Name of entity").withRequiredArg();
        this.parametersEntity = option(Arrays.asList("parameterEntity", "p"), "Parameters of entity").withRequiredArg();
    }

    @Override
    protected ExitStatus run(OptionSet options) throws Exception {
        String nameClass = (String) options.valueOf("n");
        String parametersClass = (String) options.valueOf("p");

        if (nameClass == null || nameClass.replace(" ", "").isEmpty()) {
            System.out.println("[INFO] - name of entity is required. use: -n ${entity_name}");
            return ExitStatus.ERROR;
        }
        if (parametersClass == null || parametersClass.replace(" ", "").isEmpty()){
            System.out.println("[INFO] - parameters of entity is required. use: -p ${parameters}");
            return ExitStatus.ERROR;
        }

        generateModelJava(nameClass, parametersClass);
        return ExitStatus.OK;
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
