package br.com.netodevel.generator;

import br.com.netodevel.commons.io.FileHelper;
import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Spectrum.class)
public class GeneratorTest {{

    describe("given generateContent a template", ()-> {
        it("should be return hello world", ()-> {
            GeneratorModel generatorModel = new GeneratorModel();
            generatorModel.setPathFile("templates/template-hello-world.txt");

            HashMap<String, String> variables = new HashMap<>();
            variables.put("${HELLO_WORLD}", "Hello World!");
            generatorModel.setVariables(variables);

            Generator generator = new Generator();
            generator.setFileHelper(new FileHelper());
            String templateGenerated = generator.generateContent(generatorModel);

            assertEquals("Hello World!", templateGenerated);
        });

        it("should launch illegal exception", ()-> {
            GeneratorModel generatorModel = new GeneratorModel();
            generatorModel.setPathFile("fake_value");

            Generator generator = new Generator();
            assertThrows(IllegalArgumentException.class, () -> {
                generator.generateContent(generatorModel);
            });
        });
    });
}}
