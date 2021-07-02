package org.predjeskovic.solutionCompany.config;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionConfig {

    private static ProcessBuilder pb = new ProcessBuilder();
    private static Properties props = new Properties();

    private static Connection connection;

    private static DataSource dataSource = new DataSource();

    /**
     *
     * @return Connection for postgresDB, used only for tests
     */
    public static Connection getDBConnection(){
        try {
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

    /**
     *
     * @return DataSource to connect postgres with tomcat server
     */
    public static DataSource getDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/ITSolutionCompany");
        dataSource.setUsername(pb.environment().get("dbuser"));
        dataSource.setPassword( pb.environment().get("dbpassword"));
        return dataSource;
    }

    public static void closeDatasource(){
        dataSource.close();
    }
}
