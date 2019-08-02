package br.com.templates.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
                "public class User {\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "\tprivate List<Foo> foo;\n" +
                "}\n";

        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        String returnedValue = entityGenerator.run("User", valueArgument);
        assertEquals(expectedValue.trim(), returnedValue.trim());
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

    @Test
    public void shouldReturnHasManyRelation() {
        String attributes = "Foo:references(relation:hasMany, foo:String)";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private List<Foo> foo;", valueReturned);
    }

    @Test
    public void shouldReturnBelongsToRelation() {
        String attributes = "Foo:references(relation:belongsTo, foo:String)";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private Foo foo;", valueReturned);
    }

    @Test(expected = EntityValidator.class)
    public void givenReferences_wheRelationEmpty_shouldInvokeException() {
        String attributes = "Foo:references(foo:String)";
        entityGenerator.generateAttribute(attributes);
    }

    @Test
    public void shouldReturnCorrectNameHasNameRelation() {
        String attributes = "Books:references(relation:hasMany, foo:String)";
        String valueReturned = entityGenerator.generateAttribute(attributes);
        assertEquals("private List<Books> books;", valueReturned);
    }

    @Test
    public void givenStringBetweenParentheses_shouldReturnAttributes() {
        String attributes = "Foo:references(relation:belongsTo foo:String)";
        String getAttributesReferences = entityGenerator.getAttributesOfReferences(attributes);
        assertEquals("relation:belongsTo foo:String", getAttributesReferences);
    }

    @Test
    public void shouldReturnRelation() {
        String attributes = "relation:belongsTo foo:String";
        String getAttributesReferences = entityGenerator.getRelation(attributes);
        assertEquals("belongsTo", getAttributesReferences);
    }

    @Test
    public void shouldReturnScaffoldPattern() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        String returnConverted = entityGenerator.toPatternScaffold(attributes);
        assertEquals("name:String age:Int Foo:references(relation:hasMany,foo:String)", returnConverted);
    }

    @Test
    public void shouldReturnReferencesAttributeComplete() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        List<String> getAttributesReferences = entityGenerator.getReferencesComplete(attributes);
        assertEquals("Foo:references(relation:hasMany,foo:String)", getAttributesReferences.get(0));
    }

    @Test
    public void shouldReturnReferencesAttributes() {
        String attributes = "name:String age:Int Foo:references(relation:hasMany, foo:String) Books:references(relation:belongsTo, foo:String)";
        List<String> getAttributesReferences = entityGenerator.getReferencesComplete(attributes);
        assertEquals("Foo:references(relation:hasMany,foo:String)", getAttributesReferences.get(0));
        assertEquals("Books:references(relation:belongsTo,foo:String)", getAttributesReferences.get(1));
    }

}