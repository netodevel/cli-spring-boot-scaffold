package br.com.templates.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class EntityExecutor {

    private static final List<String> supportedTypes = asList("String", "Int", "Date");
    private List<EntityCache> entities;

    public String run(String nameClass, String argumentValue) {
        entities = new ArrayList<>();
        String generatedClass = this.generateClass(nameClass);

        argumentValue = toPatternScaffold(argumentValue);
        String[] attributes = argumentValue.split(" ");

        StringBuilder attributeToReplace = new StringBuilder();
        for (int i = 0; i < attributes.length; i++) {
            String attribute = generateAttribute(attributes[i]);
            attributeToReplace.append("\t".concat(attribute.concat("\n")));
        }

        generatedClass = generatedClass.replace("${attributes}", attributeToReplace.toString());
        entities.add(new EntityCache(nameClass, generatedClass));
        return generatedClass;
    }

    public String generateAttribute(String attribute) {
        if (attribute.contains("references")) {
            String relationship = generateRelationship(attribute);
            if (relationship != null) return relationship;
        }

        validateTokenAtrribute(attribute);
        String[] splitAttribute = attribute.split(":");
        validateTypes(splitAttribute[1]);

        if (attribute.contains("Int")) return "private Integer ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("Date")) return "private Date ".concat(splitAttribute[0]).concat(";");
        if (attribute.contains("String")) return "private String ".concat(splitAttribute[0]).concat(";");

        return null;
    }

    private String generateRelationship(String attribute) {
        String attributesOfReferences = getAttributesOfReferences(attribute);
        String[] attributes = attributesOfReferences.split(",");

        String classIdentify = attribute.replace(attributesOfReferences, "");
        String[] indentifySplit = classIdentify.split(":");

        String clazzName = indentifySplit[0];
        String relation = attributes[0].split(":")[1];

        generateRelationshipClass(attributes, clazzName);

        if (relation.equals("hasMany"))
            return ("\t\n" +
                "\t@OneToMany\n"+
                "\tprivate List<").concat(clazzName).concat(">").concat(" ".concat(clazzName.toLowerCase()).concat(";"));
        if (relation.equals("belongsTo"))
            return  ("\t\n" +
                    "\t@OneToOne\n" +
                    "\tprivate ").concat(clazzName).concat(" ".concat(clazzName.toLowerCase()).concat(";"));
        return null;
    }

    private void generateRelationshipClass(String[] attributes, String clazzName) {
        String generatedClass = this.generateClass(clazzName);
        StringBuilder attributeToReplace = new StringBuilder();
        for (int i = 1; i < attributes.length; i++) {
            String attributeOfRelation = generateAttribute(attributes[i]);
            attributeToReplace.append("\t".concat(attributeOfRelation.concat("\n")));
        }

        generatedClass = generatedClass.replace("${attributes}", attributeToReplace.toString());
        if (entities != null) entities.add(new EntityCache(clazzName, generatedClass));
    }

    private void validateTypes(String o) {
        if (!supportedTypes.contains(o))
            throw new EntityValidator(o.concat(" not supported."));
    }

    private void validateTokenAtrribute(String attribute) {
        if (!attribute.contains(":")) throw new EntityValidator("attribute should contains ':' ");
    }

    public String generateClass(String nameClass) {
        return "" +
                "@Data\n" +
                "public class ".concat(nameClass).concat(" {\n") +
                "${attributes}" +
                "}";
    }

    public String getAttributesOfReferences(String attributes) {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(attributes);
        String result = "";
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public String getRelation(String attributes) {
        String[] splitAttributes = attributes.split(" ");
        String[] splitRelation = splitAttributes[0].split(":");
        return splitRelation[1];
    }

    public List<String> getReferencesComplete(String attributes) {
        String attributesConverted = toPatternScaffold(attributes);
        String[] attributesSplited = attributesConverted.split(" ");

        List<String> attributesToReturn = new ArrayList<>();
        for (int i = 0; i < attributesSplited.length; i++) {
            if (attributesSplited[i].contains("references")) {
                attributesToReturn.add(attributesSplited[i]);
            }
        }
        return attributesToReturn;
    }

    public String toPatternScaffold(String attributes) {
        return attributes.replace(", ", ",");
    }

    public List<EntityCache> getEntities() {
        return entities;
    }
}
