package br.com.netodevel.generators.java.model;

/**
 * @author IvanMarreta
 */
public enum VariableTypeImport {

	STRING("import java.lang.String;"),
	INTEGER("import java.lang.Integer;"),
	DOUBLE("import java.lang.Double;"), 
	FLOAT("import java.lang.Float;"),
	LONG("import java.lang.Long;"),
	SHORT("import java.lang.Short;"),
	BYTE("import java.lang.Byte;"),
	CHAR("import java.lang.Char;"),
	BOOLEAN("import java.lang.Boolean;"),
	OBJECT("import java.lang.Object;"),
	DATE("import java.util.Date;"),
	BIGDECIMAL("import java.math.BigDecimal;");
	
    private String path;

    VariableTypeImport(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}