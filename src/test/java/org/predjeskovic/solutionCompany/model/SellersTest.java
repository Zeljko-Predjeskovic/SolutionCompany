package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SellersTest {

    private Sellers sellers2;

    @BeforeEach
    void init(){
        sellers2 = new Sellers();
        sellers2.setPersonalInformations(DummyModels.personalInformations2);
        sellers2.addOrder(DummyModels.orders);
        DummyModels.sellers.setPersonalInformations(DummyModels.personalInformations2);
        DummyModels.sellers.addOrder(DummyModels.orders);
        sellers2.setId(10L);
    }

    @Test
    public void verifySellers(){
        Assertions.assertTrue(DummyModels.sellers.isNew());
        Assertions.assertTrue(!sellers2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.sellers.equals(sellers2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.sellers.hashCode()!=sellers2.hashCode());
    }

}
