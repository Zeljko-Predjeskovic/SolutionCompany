package org.predjeskovic.solutionCompany.model;

import java.util.ArrayList;

public class Sellers extends Persistable{

    private PersonalInformations personalInformations;

    private ArrayList<Orders> ordersList;

    protected Sellers(){

    }

    public PersonalInformations getPersonalInformations() {
        return personalInformations;
    }

    public void setPersonalInformations(PersonalInformations personalInformations) {
        this.personalInformations = personalInformations;
    }

    public ArrayList<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(ArrayList<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Orders order){
        if(ordersList == null){
            ordersList = new ArrayList<Orders>();
        }
        ordersList.add(order);
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "personalInformations=" + personalInformations +
                ", ordersList=" + ordersList +
                '}';
    }
}
