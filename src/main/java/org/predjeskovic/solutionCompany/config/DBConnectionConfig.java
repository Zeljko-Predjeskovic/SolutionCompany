package org.predjeskovic.solutionCompany.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionConfig {


    private static Connection connection;

    public static Connection getDBConnection(){
        try {
            ProcessBuilder pb = new ProcessBuilder();
            Properties props = new Properties();
            props.setProperty("user", pb.environment().get("dbuser"));
            props.setProperty("password", pb.environment().get("dbpassword"));
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ITSolutionCompany", props);
        }
        catch (SQLException e){
            throw new RuntimeException("Failed to connect to database", e);
        }

        return connection;
    }

    public static void closeConnection(){
        try {
            if (getDBConnection() != null) {
                getDBConnection().close();
            }
        }catch (SQLException e){
            throw new RuntimeException("Failed closing Database",e);
        }
    }
}
