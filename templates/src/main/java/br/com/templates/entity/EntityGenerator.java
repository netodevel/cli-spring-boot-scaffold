package br.com.templates.entity;

import java.util.List;

import static java.util.Arrays.asList;

public class EntityGenerator {

    private static final List<String> supportedTypes = asList("String", "Int", "Date");

    public String run(String nameClass, String argumentValue) {
        if (argumentValue.contains("references")) {
            return "" +
                    "@Data\n" +
                    "class User {\n" +
                    "    private String name;\n" +
                    "    private Integer age;\n" +
                    "    private List<Foo> foo;\n" +
                    "}\n";
        }

        String generatedClass = this.generateClass(nameClass);
        String[] attributes = argumentValue.split(" ");

        StringBuilder attributeToReplace = new StringBuilder();
        for (int i = 0; i < attributes.length; i++) {
            String attribute = generateAttribute(attributes[i]);
            attributeToReplace.append("\t".concat(attribute.concat("\n")));
        }
        generatedClass = generatedClass.replace("${attributes}", attributeToReplace.toString());

        return generatedClass;
    }

    public String generateAttribute(String attribute) {
        if (!attribute.contains(":")) throw new EntityValidator("attribute should contains ':' ");
        String[] splitAttribute = attribute.split(":");
        if (!supportedTypes.contains(splitAttribute[1])) throw new EntityValidator(splitAttribute[1].concat(" not supported."));

        if (attribute.contains("Int")) return "private Integer ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("Date")) return "private Date ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("String")) return "private String ".concat(splitAttribute[0]).concat(";");
        return null;
    }

    public String generateClass(String nameClass) {
        return  "" +
                "@Data\n" +
                "public class ".concat(nameClass).concat(" {\n")+
                "${attributes}" +
                "}";
    }
}
