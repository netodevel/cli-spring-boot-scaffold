package br.com.templates.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityGeneratorTest {

    private EntityGenerator entityGenerator;

    @Before
    public void setUp() {
        entityGenerator = new EntityGenerator();
    }

    @Test
    public void shouldCreateEntity() {
        String expectedValue = "" +
                "@Data\n" +
                "public class User {\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "}\n";

        String returnedValue = entityGenerator.run("User", "name:String age:Int");
        assertEquals(expectedValue.trim(), returnedValue.trim());
    }

    @Test(expected = EntityValidator.class)
    public void shouldReturnException() {
        entityGenerator.generateAttribute("name");
    }

    @Test(expected = EntityValidator.class)
    public void givenTypeThatNotExists_shouldInvokeException() {
        entityGenerator.generateAttribute("name:OtherType");
    }

    @Test
    public void shouldReturnWithRelations() {
        String expectedValue = "" +
                "@Data\n" +
                "class User {\n" +
                "    private String name;\n" +
                "    private Integer age;\n" +
                "    private List<Foo> foo;\n" +
                "}\n";

        String valueArgument = "name:String age:Int Foo:references(relation:hasMany foo:String)";

        String returnedValue = entityGenerator.run("User", valueArgument);
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void shouldGenerateClass() {
        String expectedValue = "" +
                "@Data\n" +
                "public class User {\n" +
                "${attributes}" +
                "}";

        String returned = entityGenerator.generateClass("User");
        assertEquals(expectedValue, returned);
    }

    @Test
    public void shouldGenerateClassWithCorrectName() {
        String expectedValue = "" +
                "@Data\n" +
                "public class Foo {\n" +
                "${attributes}" +
                "}";

        String returned = entityGenerator.generateClass("Foo");
        assertEquals(expectedValue, returned);
    }

    @Test
    public void shouldGenerateStringAttribute() {
        String attributes = "name:String";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private String name;", valueReturned);
    }

    @Test
    public void shouldGeneratorIntegerAttribute() {
        String attributes = "age:Int";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private Integer age;", valueReturned);
    }

    @Test
    public void shouldGeneratorDateAttribute() {
        String attributes = "created:Date";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private Date created;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameStringAttribute() {
        String attributes = "description:String";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private String description;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameIntegerAttribute() {
        String attributes = "count:Int";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private Integer count;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameDateAttribute() {
        String attributes = "updated:Date";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private Date updated;", valueReturned);
    }

}