package br.com.generate;

import static br.com.cli.SpringGenerateMain.DATABASE;

/**
 * Created by ivanmarreta on 25/11/16.
 */
public class DatabaseConfiguration {

    public static final String MYSQL = "mysql";
    public static final String POSTGRES = "postgres";
    public static final String POSTGRES_PORT = ":5432";

    public static String getDataBase(String[] optionValues) {
        try{
            String databaseName = optionValues[DATABASE];
            if (isMysql(databaseName) || isPostgres(databaseName))
                return databaseName;
        }catch (Exception e){
            return MYSQL;
        }
        return MYSQL;
    }

    public static String getPort(String database) {
        return isMysql(database) ? "" : POSTGRES_PORT;
    }

    private static boolean isMysql(String database) {
        return MYSQL.equals(database.toLowerCase());
    }

    private static boolean isPostgres(String database) {
        return POSTGRES.equals(database.toLowerCase());
    }


}
