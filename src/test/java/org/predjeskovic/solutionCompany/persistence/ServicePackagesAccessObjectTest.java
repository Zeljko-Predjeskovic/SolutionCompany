package org.predjeskovic.solutionCompany.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.predjeskovic.solutionCompany.model.ServicePackages;

import javax.annotation.processing.ProcessingEnvironment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class ServicePackagesAccessObjectTest {

    Connection connection;
    private ServicePackagesAccessObject servicePackagesAccessObject;
    private static Long id;



    @BeforeEach
    void intializeDB() {
        try {
            ProcessBuilder pb = new ProcessBuilder();
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password", pb.environment().get("dbpassword"));
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/ITSolutionCompany",props);
            servicePackagesAccessObject = new ServicePackagesAccessObject(connection);

        }
        catch (SQLException e){
            throw new RuntimeException("Failed to connect to database", e);
        }
    }


    @AfterEach
    void destroyDB(){
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("Failed closing Database",e);
        }
    }


    @Test
    @Order(1)
    void assertTeaFindAll(){
        List<ServicePackages> servicePackagesList = servicePackagesAccessObject.findAll();
        System.out.println(servicePackagesList);
        Assertions.assertThat(servicePackagesList).isNotNull();
    }



}
