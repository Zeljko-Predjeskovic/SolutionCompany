package org.predjeskovic.solutionCompany.service;

import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.model.ServicePackages;
import org.predjeskovic.solutionCompany.persistence.ServicePackagesAccessObject;

import java.util.List;

public class ServicePackagesService {


    private final ServicePackagesAccessObject servicePackagesAccessObject;

    public ServicePackagesService() {
        this.servicePackagesAccessObject = new ServicePackagesAccessObject(DBConnectionConfig.getDBConnection());
    }


    public List<ServicePackages> findAll(){
      /* return StreamSupport.stream(servicePackagesAccessObject.findAll().spliterator(), false)
                .map(PersonNodeDto::fromPersonNode)
                .collect(Collectors.toList());*/
        return null;
    }


}
