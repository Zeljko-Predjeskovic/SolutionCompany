package org.predjeskovic.solutionCompany.model;

public class ServicePackages extends Persistable{

    private String serviceName;

    private String description;

    private Integer price;

    protected ServicePackages(){

    }

    public ServicePackages(String serviceName, String description, Integer price) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServicePackages{" +
                "serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
