package org.predjeskovic.solutionCompany.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonalInformationTest {

    private PersonalInformations personalInformations2;

    @BeforeEach
    void init(){
        personalInformations2 = new PersonalInformations("Zeljko", "Predjeskovic",
                "abc@gmail.com", "123456789");
        personalInformations2.setId(10L);
    }

    @Test
    public void verifyPersonalInformations(){
        Assertions.assertTrue(DummyModels.personalInformations.isNew());
        Assertions.assertTrue(!personalInformations2.isNew());
    }

    @Test
    public void verifyEquals(){
        Assertions.assertTrue(!DummyModels.personalInformations.equals(personalInformations2));
    }

    @Test
    public void verifyHash(){
        Assertions.assertTrue(DummyModels.personalInformations.hashCode()!=personalInformations2.hashCode());
    }
}
