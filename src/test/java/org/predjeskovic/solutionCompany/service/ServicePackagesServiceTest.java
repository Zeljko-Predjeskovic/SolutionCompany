package org.predjeskovic.solutionCompany.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;

import java.util.List;

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
}
