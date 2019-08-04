package br.com.templates.config.openj9;

import br.com.generator.core.Generator;
import br.com.generator.core.GeneratorOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OpenJ9MavenPluginGenerator extends Generator {

    private GeneratorOptions generatorOptions;

    public OpenJ9MavenPluginGenerator(GeneratorOptions generatorOptions) {
        this.generatorOptions = generatorOptions;
    }

    @Override
    public File runGenerate() throws IOException {
        String plugin = "\n" +
                "<plugins>\n" +
                "            <plugin>\n" +
                "                <groupId>org.apache.maven.plugins</groupId>\n" +
                "                <artifactId>maven-shade-plugin</artifactId>\n" +
                "                <version>2.4.3</version>\n" +
                "                <dependencies>\n" +
                "                    <dependency>\n" +
                "                        <groupId>org.springframework.boot</groupId>\n" +
                "                        <artifactId>spring-boot-maven-plugin</artifactId>\n" +
                "                        <version>2.1.5.RELEASE</version>\n" +
                "                    </dependency>\n" +
                "                </dependencies>\n" +
                "                <executions>\n" +
                "                    <execution>\n" +
                "                        <phase>package</phase>\n" +
                "                        <goals>\n" +
                "                            <goal>shade</goal>\n" +
                "                        </goals>\n" +
                "                        <configuration>\n" +
                "                            <transformers>\n" +
                "                                <transformer\n" +
                "                                        implementation=\"org.apache.maven.plugins.shade.resource.AppendingTransformer\">\n" +
                "                                    <resource>META-INF/spring.handlers</resource>\n" +
                "                                </transformer>\n" +
                "                                <transformer\n" +
                "                                        implementation=\"org.springframework.boot.maven.PropertiesMergingResourceTransformer\">\n" +
                "                                    <resource>META-INF/spring.factories</resource>\n" +
                "                                </transformer>\n" +
                "                                <transformer\n" +
                "                                        implementation=\"org.apache.maven.plugins.shade.resource.AppendingTransformer\">\n" +
                "                                    <resource>META-INF/spring.schemas</resource>\n" +
                "                                </transformer>\n" +
                "                                <transformer\n" +
                "                                        implementation=\"org.apache.maven.plugins.shade.resource.ServicesResourceTransformer\"/>\n" +
                "                                <transformer\n" +
                "                                        implementation=\"org.apache.maven.plugins.shade.resource.ManifestResourceTransformer\">\n" +
                "                                    <mainClass>${main_class}</mainClass>\n" +
                "                                </transformer>\n" +
                "                            </transformers>\n" +
                "                        </configuration>\n" +
                "                    </execution>\n" +
                "                </executions>\n" +
                "                <configuration>\n" +
                "                    <createDependencyReducedPom>false</createDependencyReducedPom>\n" +
                "                </configuration>\n" +
                "            </plugin>   \n";

        Map<String, String> keyValue = new HashMap<String, String>();
        keyValue.put("<plugins>", plugin);
        this.generatorOptions.setKeyValue(keyValue);
        this.generatorOptions.setName("pom.xml");

        return addMavenPlugin(this.generatorOptions);
    }
}
