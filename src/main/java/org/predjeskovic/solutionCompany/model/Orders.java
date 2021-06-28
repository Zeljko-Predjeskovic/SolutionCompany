package org.predjeskovic.solutionCompany.model;

public class Orders extends Persistable{

    private String conditions;

    private String description;

    private Customers customer;

    private Sellers seller;

    protected Orders(){

    }

    public Orders(String conditions, String description) {
        this.conditions = conditions;
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "conditions='" + conditions + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer.toString() +
                ", seller=" + seller.toString() +
                '}';
    }
}
