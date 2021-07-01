package org.predjeskovic.solutionCompany.service;

import org.predjeskovic.solutionCompany.persistence.ServicePackagesAccessObject;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ServicePackagesService {


    private final ServicePackagesAccessObject servicePackagesAccessObject;

    public ServicePackagesService(Connection connection) {
        this.servicePackagesAccessObject = new ServicePackagesAccessObject(connection);
    }


    public List<ServicePackagesDto> findAll(){
       return (List<ServicePackagesDto>) StreamSupport.stream(servicePackagesAccessObject.findAll().spliterator(), false)
               .map(ServicePackagesDto::fromServicePackages)
                .collect(Collectors.toList());
    }

}
