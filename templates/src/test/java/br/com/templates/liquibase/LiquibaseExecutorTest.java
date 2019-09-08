package br.com.templates.liquibase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiquibaseExecutorTest {

    private LiquibaseExecutor liquibaseExecutor;

    @Before
    public void setUp() {
        liquibaseExecutor = new LiquibaseExecutor();
    }

    @Test
    public void deveGerarColumns() {
        String result = liquibaseExecutor.generateColumns("User", "name:String age:Int created:Date");
        System.out.println(result);
    }

    @Test
    public void quandoInteger_deveRetornarColumnBigInt() {
        String expected = "<column name=\"idade\" type=\"BIGINT\"\\>";
        String result = liquibaseExecutor.generateColumn("idade", "Int");
        assertEquals(expected, result);
    }

    @Test
    public void quandoString_deveRetornarColumnVarchar() {
        String expected = "<column name=\"nome\" type=\"VARCHAR(255)\"\\>";
        String result = liquibaseExecutor.generateColumn("nome", "String");
        assertEquals(expected, result);
    }

    @Test
    public void quandoDate_deveRetornarColumnDateTime() {
        String expected = "<column name=\"created\" type=\"DATETIME\"\\>";
        String result = liquibaseExecutor.generateColumn("created", "Date");
        assertEquals(expected, result);
    }

    @Test
    @Ignore
    public void deveRetornarProximoNumeroMigration() {
        String expectedValue = "03";
        String result = liquibaseExecutor.getChangeSetNumber();
        assertEquals(expectedValue, result);
    }

}