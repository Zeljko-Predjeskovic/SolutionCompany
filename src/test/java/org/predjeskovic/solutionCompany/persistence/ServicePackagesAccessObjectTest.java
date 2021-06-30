package org.predjeskovic.solutionCompany.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.model.DummyModels;
import org.predjeskovic.solutionCompany.model.ServicePackages;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServicePackagesAccessObjectTest {

    Connection connection;
    private ServicePackagesAccessObject servicePackagesAccessObject;
    private static Long id;



    @BeforeEach
    void intializeDB() {
            servicePackagesAccessObject = new ServicePackagesAccessObject(DBConnectionConfig.getDBConnection());
    }


    @AfterEach
    void destroyDB(){
        DBConnectionConfig.closeConnection();
    }


    @Test
    @Order(1)
    public void assertTeaFindAll(){
        List<ServicePackages> servicePackagesList = servicePackagesAccessObject.findAll();
        System.out.println(servicePackagesList);
        Assertions.assertThat(servicePackagesList).isNotNull();
    }

    @Test
    @Order(2)
    public void assertInsert(){
       Long id = servicePackagesAccessObject.insert(DummyModels.servicePackages).getId();

       Assertions.assertThat(id != null);

    }

    @Test
    @Order(3)
    public void assertUpdate(){
        ServicePackages servicePackages = DummyModels.servicePackages;
        servicePackages.setId(5L);
        Assertions.assertThat(servicePackagesAccessObject.update(servicePackages)!=null);
    }


}
