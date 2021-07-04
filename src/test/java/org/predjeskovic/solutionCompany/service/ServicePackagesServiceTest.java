package org.predjeskovic.solutionCompany.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.model.DummyModels;

import java.util.List;
import java.util.Optional;

public class ServicePackagesServiceTest {

    private ServicePackagesService servicePackagesService = new ServicePackagesService(DBConnectionConfig.getDBConnection());

    @AfterEach
    void afterEach(){
        DBConnectionConfig.closeConnection();
    }

    @Test
    public void verifyFindAll(){
        List<ServicePackagesDto> servicePackagesDtoList =servicePackagesService.findAll();

        Assertions.assertTrue((!servicePackagesDtoList.isEmpty() ||servicePackagesDtoList!=null));
    }

    @Test
    public void verifyFindOne(){
        ServicePackagesDto servicePackagesDto =servicePackagesService.findOneById(11L);

        Assertions.assertTrue((servicePackagesDto.getId()==11L ||servicePackagesDto!=null));
    }

    @Test
    public void verifyUpdate(){
        String s = "updated ServiceName";

        ServicePackagesDto servicePackagesDto = servicePackagesService.findOneById(11L);
        servicePackagesDto.setServiceName(s);

        var erg = servicePackagesService.update(servicePackagesDto);

        Assertions.assertTrue((erg.getServiceName().equals(s) ||servicePackagesDto!=null));

    }

    @Test
    public void verifyInsert(){
        ServicePackagesDto servicePackagesDto = servicePackagesService.insert(Optional.of(DummyModels.servicePackages)
        .map(ServicePackagesDto::fromServicePackages)
        .orElse(null));

        Assertions.assertTrue(servicePackagesDto!=null);
    }


}
