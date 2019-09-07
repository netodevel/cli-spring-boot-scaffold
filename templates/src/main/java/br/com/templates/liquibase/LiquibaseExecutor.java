package br.com.templates.liquibase;

public class LiquibaseExecutor {

    public String generateColumns(String className, String parameters) {
        String[] attributes = parameters.split(" ");
        String result = "\t" + generateId() + "\n";
        for (int i = 0; i < attributes.length; i++) {
            String[] splitParams = attributes[i].split(":");
            result += "\t\t\t\t" + generateColumn(splitParams[0], splitParams[1]) + "\n";
        }
        return result;
    }

    public String generateId() {
        String id = "<column name=\"id\" autoIncrement=\"true\" type=\"BIGINT\">\n" +
                "\t\t\t\t\t\t<constraints primaryKey=\"true\" nullable=\"false\"/>\n" +
                "\t\t\t\t</column>";

        return id;
    }

    public String generateColumn(String paramName, String type) {
        return "<column name=\"" + paramName + "\" type=\"" + convertType(type) + "\"\\>";
    }

    public String convertType(String type) {
        if (type.equals("String")) {
            return "VARCHAR(255)";
        }
        if (type.equals("Int")) {
            return "BIGINT";
        }
        if (type.equals("Date")) {
            return "DATETIME";
        }
        return null;
    }

}
