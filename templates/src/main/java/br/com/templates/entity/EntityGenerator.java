package br.com.templates.entity;

public class EntityGenerator {

    public String run(String name, String argumentValue) {
        if (argumentValue.contains("references")) {
            return "" +
                    "@Data\n" +
                    "class User {\n" +
                    "    private String name;\n" +
                    "    private Integer age;\n" +
                    "    private List<Foo> foo;\n" +
                    "}\n";
        }

        String expectedValue = "" +
                "@Data\n" +
                "class User {\n" +
                "    private String name;\n" +
                "    private Integer age;\n" +
                "}\n";

        return expectedValue;
    }

    public String generateAttribute(String attribute) {
        if (!attribute.contains(":")) throw new EntityValidator("attribute should contains ':' ");
        String[] splitAttribute = attribute.split(":");

        if (attribute.contains("Int")) return "private Integer ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("Date")) return "private Date ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("String")) return "private String ".concat(splitAttribute[0]).concat(";");
        return null;
    }

}
