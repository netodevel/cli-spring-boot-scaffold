package br.com.netodevel.generator;

import br.com.netodevel.commons.io.FileHelper;
import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Spectrum.class)
public class GeneratorValidatorTest {{

    describe("given generateContent a template", ()-> {
        it("should launch exception when file is null", ()-> {
            GenerateValidator generateValidator = new GenerateValidator();
            GeneratorModel generatorModel = new GeneratorModel();
            generatorModel.setPathFile(null);

            HashMap<String, String> variables = new HashMap<>();
            variables.put("MY_VAR", "MY_VALUE");
            generatorModel.setVariables(variables);

            assertThrows(IllegalArgumentException.class, () -> {
                generateValidator.validate(generatorModel);
            });
        });

        it("should launch exception when file is empty", ()-> {
            GenerateValidator generateValidator = new GenerateValidator();
            GeneratorModel generatorModel = new GeneratorModel();
            generatorModel.setPathFile("");

            HashMap<String, String> variables = new HashMap<>();
            variables.put("MY_VAR", "MY_VALUE");
            generatorModel.setVariables(variables);

            assertThrows(IllegalArgumentException.class, () -> {
                generateValidator.validate(generatorModel);
            });
        });

        it("should launch exception when FileHelper is null", ()-> {
            GenerateValidator generateValidator = new GenerateValidator();

            Generator generator = new Generator();
            assertThrows(IllegalArgumentException.class, () -> {
                generateValidator.validateDeps(generator);
            });
        });
    });

}}
