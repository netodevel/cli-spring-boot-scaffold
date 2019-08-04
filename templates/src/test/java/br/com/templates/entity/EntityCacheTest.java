package br.com.templates.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityCacheTest {

    private EntityExecutor entityExecutor;

    @Before
    public void setUp() {
        entityExecutor = new EntityExecutor();
    }

    @Test
    public void shouldReturnTwoEntities() {
        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        entityExecutor.run("User", valueArgument);
        assertEquals(2, entityExecutor.getEntities().size());
    }

    @Test
    public void shouldReturnContentOfUser() {
        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        entityExecutor.run("User", valueArgument);

        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class User {\n" +
                "\tprivate String name;\n" +
                "\tprivate Integer age;\n" +
                "\t\t\n" +
                "\t@OneToMany\n" +
                "\tprivate List<Foo> foo;\n" +
                "}\n";
        assertEquals(expectedValue.trim(), entityExecutor.getEntities().get(1).getContent());
    }

    @Test
    public void shouldReturnContentOfFoo() {
        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String)";
        entityExecutor.run("User", valueArgument);

        String expectedValue = "" +
                "@Entity\n" +
                "@Data\n" +
                "public class Foo {\n" +
                "\tprivate String foo;\n" +
                "}\n";
        assertEquals(expectedValue.trim(), entityExecutor.getEntities().get(0).getContent());
    }

    @Test
    public void shouldReturnThreeCount() {
        String valueArgument = "name:String age:Int Foo:references(relation:hasMany, foo:String) Bar:references(relation:belongsTo, bar:String)";
        entityExecutor.run("User", valueArgument);
        assertEquals(3, entityExecutor.getEntities().size());
    }

}
