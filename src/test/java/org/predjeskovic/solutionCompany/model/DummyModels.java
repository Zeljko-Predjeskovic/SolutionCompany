package org.predjeskovic.solutionCompany.model;

import org.predjeskovic.solutionCompany.model.*;

import java.util.ArrayList;

public class DummyModels{

    public static Addresses addresses = new Addresses("vienna", "1050", "Spengergasse");

    public static PersonalInformations personalInformations= new PersonalInformations("Zeljko", "Predjeskovic",
            "abc@gmail.com", "123456789");

    public static PersonalInformations personalInformations2 = new PersonalInformations("Thomas", "Mueller",
            "axyzgmail.com", "1234549939");

    public static ServicePackages servicePackages = new ServicePackages("Sql cloud DB",
            "Cloud service for data storage", 20);

    public static Customers customers = new Customers();

    public static Sellers sellers = new Sellers();

    public static Orders orders = new Orders("function1, function2, function3", "Website for users");

}
