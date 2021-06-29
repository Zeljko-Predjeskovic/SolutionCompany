package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicePackagesTest {

    private ServicePackages servicePackages2;

    @BeforeEach
    void init(){
        servicePackages2 = new ServicePackages("Sql cloud DB",
                "Cloud service for data storage", 20);
        servicePackages2.setId(10L);
    }

    @Test
    public void verifyServicePackages(){
        Assertions.assertTrue(DummyModels.servicePackages.isNew());
        Assertions.assertTrue(!servicePackages2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.servicePackages.equals(servicePackages2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.servicePackages.hashCode()!=servicePackages2.hashCode());
    }

}
