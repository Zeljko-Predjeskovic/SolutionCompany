package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomersTest {


    private Customers customers2;

    @BeforeEach
    void init(){
        customers2 = new Customers();
        customers2.addServicePackage(DummyModels.servicePackages);
        customers2.setPersonalInformations(DummyModels.personalInformations);
        DummyModels.customers.addServicePackage(DummyModels.servicePackages);
        DummyModels.customers.setPersonalInformations(DummyModels.personalInformations);
        customers2.setId(10L);
    }

    @Test
    public void verifyCustomers(){
        Assertions.assertTrue(DummyModels.customers.isNew());
        Assertions.assertTrue(!customers2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.customers.equals(customers2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.customers.hashCode()!=customers2.hashCode());
    }


}
