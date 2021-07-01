package org.predjeskovic.solutionCompany.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.model.DummyModels;
import org.predjeskovic.solutionCompany.model.ServicePackages;

import java.util.List;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServicePackagesAccessObjectTest {

    private ServicePackagesAccessObject servicePackagesAccessObject;

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
    public void assertFindAll(){
        List<ServicePackages> servicePackagesList = servicePackagesAccessObject.findAll();
        Assertions.assertThat(servicePackagesList).isNotNull();
    }

    @Test
    @Order(2)
    public void assertFindOne(){
        Assertions.assertThat(servicePackagesAccessObject.findOne(11L)!=null);
    }

    @Test
    @Order(3)
    public void assertInsert(){
       Long id = servicePackagesAccessObject.insert(DummyModels.servicePackages).getId();

       Assertions.assertThat(id != null);

    }

    @Test
    @Order(4)
    public void assertUpdate(){
        ServicePackages servicePackages = DummyModels.servicePackages;
        servicePackages.setId(9L);
        Assertions.assertThat(servicePackagesAccessObject.update(servicePackages)!=null);
    }

    @Test
    @Order(5)
    public void assertDelete(){
        ServicePackages servicePackages = (ServicePackages) servicePackagesAccessObject.insert(DummyModels.servicePackages);
        Assertions.assertThat(servicePackagesAccessObject.delete(servicePackages));
    }


}
