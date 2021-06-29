package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressesTest {

    private Addresses addresses2;

    @BeforeEach
    void init(){
        addresses2 = new Addresses("vienna", "1050", "Spengergasse");
        addresses2.setId(10L);
    }

    @Test
    public void verifyAddresses(){
        Assertions.assertTrue(DummyModels.addresses.isNew());
        Assertions.assertTrue(!addresses2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.addresses.equals(addresses2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.addresses.hashCode()!=addresses2.hashCode());
    }

}
