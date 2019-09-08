package br.com.templates.liquibase;

import br.com.generate.helpers.ScaffoldInfoHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public String getChangeSetNumber() {
        ScaffoldInfoHelper scaffoldInfoHelper = new ScaffoldInfoHelper();
        try (Stream<Path> paths = Files.walk(Paths.get(scaffoldInfoHelper.getUserDir() + "/src/main/resources/db/changelog/"))) {
            List<Integer> listNumberMigrations = paths
                    .filter(Files::isRegularFile)
                    .map(this::getNumber).collect(Collectors.toList());
            return generateNextNumberMigration(listNumberMigrations);
        } catch (IOException e) {
            System.out.println("ERROR: ".concat(e.getMessage()));
            return null;
        }
    }

    private String generateNextNumberMigration(List<Integer> listNumberMigrations) {
        Integer currentNumber = (listNumberMigrations.get(listNumberMigrations.size() - 1));
        Integer nextNumber = currentNumber + 1;
        if (nextNumber < 10) {
            String padded = String.format("%02d", nextNumber);
            return padded;
        }
        return String.valueOf(nextNumber);
    }

    private Integer getNumber(Path s) {
        String fileName = s.getFileName().toString();
        String[] splitName = fileName.split("-");
        return Integer.parseInt(splitName[0].replace("0", ""));
    }

}
