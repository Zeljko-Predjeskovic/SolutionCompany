package org.predjeskovic.solutionCompany.model;

import java.util.ArrayList;

public class Customers extends Persistable{

    private PersonalInformations personalInformations;

    private ArrayList<ServicePackages> servicePackagesList = new ArrayList<ServicePackages>();

    protected Customers(){

    }

    public PersonalInformations getPersonalInformations() {
        return personalInformations;
    }

    public void setServicePackagesList(ArrayList<ServicePackages> servicePackagesList) {
        this.servicePackagesList = servicePackagesList;
    }

    public void setPersonalInformations(PersonalInformations personalInformations) {
        this.personalInformations = personalInformations;
    }

    public ArrayList<ServicePackages> getServicePackagesList() {
        return servicePackagesList;
    }

    public void addServicePackage(ServicePackages servicePackage){
        if(servicePackage==null){
            servicePackagesList = new ArrayList<ServicePackages>();
        }
            servicePackagesList.add(servicePackage);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "personalInformations=" + personalInformations.toString() +
                ", servicePackagesList=" + servicePackagesList +
                '}';
    }


}
