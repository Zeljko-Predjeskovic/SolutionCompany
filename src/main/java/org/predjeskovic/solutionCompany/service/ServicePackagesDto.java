package org.predjeskovic.solutionCompany.service;

import org.predjeskovic.solutionCompany.model.Persistable;
import org.predjeskovic.solutionCompany.model.ServicePackages;

public class ServicePackagesDto {

    private Long id;

    private String serviceName;

    private String description;

    private Integer price;

    public ServicePackagesDto() {
    }

    public ServicePackagesDto(Long id, String serviceName, String description, Integer price) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public static ServicePackagesDto fromServicePackages(Object sp){
        ServicePackages servicePackages = (ServicePackages) sp;

        ServicePackagesDto servicePackagesDto = new ServicePackagesDto(
                servicePackages.getId(),
                servicePackages.getServiceName(),
                servicePackages.getDescription(),
                servicePackages.getPrice());

        return servicePackagesDto;
    }

    public ServicePackages toServicePackages(){
        var servicePackages = new ServicePackages(serviceName, description, price);

        servicePackages.setId(id);

        return servicePackages;
    }

    public ServicePackages mergeWith(ServicePackages servicePackages){
        ServicePackages servicePackagesMerged = new ServicePackages(serviceName,description,price);

        servicePackagesMerged.setId(servicePackages.getId());

        return servicePackagesMerged;
    }

    @Override
    public String toString() {
        return "ServicePackagesDto{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
