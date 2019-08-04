package br.com.templates.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EntityExecutorTest {

    private EntityExecutor entityExecutor;

    @Before
    public void setUp() {
        entityExecutor = new EntityExecutor();
    }

    @Test
    public void shouldCreateEntity() {
        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class User {\n" +
                "\t\n" +
                "\t@Id @GeneratedValue(strategy = GenerationType.AUTO)\n" +
                "\tprivate Integer id;\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "}\n";

        String returnedValue = entityExecutor.run("User", "name:String age:Int");
        assertEquals(expectedValue.trim(), returnedValue.trim());
    }

    @Test(expected = EntityValidator.class)
    public void shouldReturnException() {
        entityExecutor.generateAttribute("name");
    }

    @Test(expected = EntityValidator.class)
    public void givenTypeThatNotExists_shouldInvokeException() {
        entityExecutor.generateAttribute("name:OtherType");
    }

    @Test
    public void givenRelationHasMany_shouldReturnWithRelation() {
        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class User {\n" +
                "\t\n" +
                "\t@Id @GeneratedValue(strategy = GenerationType.AUTO)\n" +
                "\tprivate Integer id;\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "\t\t\n" +
                "\t@OneToMany\n" +
                "\tprivate List<Foo> foo;\n" +
                "}\n";

        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        String returnedValue = entityExecutor.run("User", valueArgument);
        assertEquals(expectedValue.trim(), returnedValue.trim());
    }

    @Test
    public void givenRelationBelongsTo_shouldReturnWithRelation() {
        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class User {\n" +
                "\t\n" +
                "\t@Id @GeneratedValue(strategy = GenerationType.AUTO)\n" +
                "\tprivate Integer id;\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "\t\t\n" +
                "\t@OneToOne\n" +
                "\tprivate Foo foo;\n" +
                "}\n";

        String valueArgument = "name:String age:Int Foo:references(relation:belongsTo, foo:String)";
        String returnedValue = entityExecutor.run("User", valueArgument);
        assertEquals(expectedValue.trim(), returnedValue.trim());
    }

    @Test
    public void shouldGenerateClass() {
        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class User {\n" +
                "${attributes}" +
                "}";

        String returned = entityExecutor.generateClass("User");
        assertEquals(expectedValue, returned);
    }

    @Test
    public void shouldGenerateClassWithCorrectName() {
        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class Foo {\n" +
                "${attributes}" +
                "}";

        String returned = entityExecutor.generateClass("Foo");
        assertEquals(expectedValue, returned);
    }

    @Test
    public void shouldGenerateStringAttribute() {
        String attributes = "name:String";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private String name;", valueReturned);
    }

    @Test
    public void shouldGeneratorIntegerAttribute() {
        String attributes = "age:Int";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private Integer age;", valueReturned);
    }

    @Test
    public void shouldGeneratorDateAttribute() {
        String attributes = "created:Date";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private Date created;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameStringAttribute() {
        String attributes = "description:String";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private String description;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameIntegerAttribute() {
        String attributes = "count:Int";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private Integer count;", valueReturned);
    }

    @Test
    public void shouldReturnCorrectNameDateAttribute() {
        String attributes = "updated:Date";
        String valueReturned = entityExecutor.generateAttribute(attributes);
        assertEquals("private Date updated;", valueReturned);
    }

    @Test
    public void shouldReturnHasManyRelation() {
        String attributes = "Foo:references(relation:hasMany, foo:String)";
        String valueReturned = entityExecutor.generateAttribute(attributes);

        String expectedValue = "\t\n" +
                "\t@OneToMany\n" +
                "\tprivate List<Foo> foo;";
        assertEquals(expectedValue, valueReturned);
    }

    @Test
    public void shouldReturnBelongsToRelation() {
        String attributes = "Foo:references(relation:belongsTo, foo:String)";
        String valueReturned = entityExecutor.generateAttribute(attributes);

        String expectedValue = "\t\n" +
                "\t@OneToOne\n" +
                "\tprivate Foo foo;";

        assertEquals(expectedValue, valueReturned);
    }

    @Test(expected = EntityValidator.class)
    public void givenReferences_wheRelationEmpty_shouldInvokeException() {
        String attributes = "Foo:references(foo:String)";
        entityExecutor.generateAttribute(attributes);
    }

    @Test
    public void shouldReturnCorrectNameHasNameRelation() {
        String attributes = "Books:references(relation:hasMany, foo:String)";
        String valueReturned = entityExecutor.generateAttribute(attributes);

        String expectedValue = "\t\n" +
                "\t@OneToMany\n" +
                "\tprivate List<Books> books;";

        assertEquals(expectedValue, valueReturned);
    }

    @Test
    public void givenStringBetweenParentheses_shouldReturnAttributes() {
        String attributes = "Foo:references(relation:belongsTo foo:String)";
        String getAttributesReferences = entityExecutor.getAttributesOfReferences(attributes);
        assertEquals("relation:belongsTo foo:String", getAttributesReferences);
    }

    @Test
    public void shouldReturnRelation() {
        String attributes = "relation:belongsTo foo:String";
        String getAttributesReferences = entityExecutor.getRelation(attributes);
        assertEquals("belongsTo", getAttributesReferences);
    }

    @Test
    public void shouldReturnScaffoldPattern() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        String returnConverted = entityExecutor.toPatternScaffold(attributes);
        assertEquals("name:String age:Int Foo:references(relation:hasMany,foo:String)", returnConverted);
    }

    @Test
    public void shouldReturnReferencesAttributeComplete() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        List<String> getAttributesReferences = entityExecutor.getReferencesComplete(attributes);
        assertEquals("Foo:references(relation:hasMany,foo:String)", getAttributesReferences.get(0));
    }

    @Test
    public void shouldReturnReferencesAttributes() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String) Books:references(relation:belongsTo, foo:String)";
        List<String> getAttributesReferences = entityExecutor.getReferencesComplete(attributes);
        assertEquals("Foo:references(relation:hasMany,foo:String)", getAttributesReferences.get(0));
        assertEquals("Books:references(relation:belongsTo,foo:String)", getAttributesReferences.get(1));
    }

}