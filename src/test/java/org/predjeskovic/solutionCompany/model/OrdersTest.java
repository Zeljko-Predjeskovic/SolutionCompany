package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersTest {

    private Orders orders2;

    @BeforeEach
    void init(){
        orders2 =  new Orders("function1, function2, function3", "Website for users");
        orders2.setSeller(DummyModels.sellers);
        orders2.setCustomer(DummyModels.customers);
        DummyModels.orders.setSeller(DummyModels.sellers);
        DummyModels.orders.setCustomer(DummyModels.customers);
        orders2.setId(10L);
    }

    @Test
    public void verifyOrders(){
        Assertions.assertTrue(DummyModels.orders.isNew());
        Assertions.assertTrue(!orders2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.orders.equals(orders2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.orders.hashCode()!=orders2.hashCode());
    }

}
