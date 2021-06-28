package org.predjeskovic.solutionCompany.model;

import java.util.ArrayList;

public class Customers extends Persistable{

    private PersonalInformations personalInformations;

    private ArrayList<ServicePackages> servicePackagesList;

    protected Customers(){

    }

    public PersonalInformations getPersonalInformations() {
        return personalInformations;
    }

    public void setPersonalInformations(PersonalInformations personalInformations) {
        this.personalInformations = personalInformations;
    }

    public ArrayList<ServicePackages> getServicePackagesList() {
        return servicePackagesList;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "personalInformations=" + personalInformations.toString() +
                ", servicePackagesList=" + servicePackagesList +
                '}';
    }


}
