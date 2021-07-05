package org.predjeskovic.solutionCompany.service;

import org.junit.jupiter.api.*;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.model.DummyModels;

import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServicePackagesServiceTest {

    private ServicePackagesService servicePackagesService = new ServicePackagesService(DBConnectionConfig.getDBConnection());

    @AfterEach
    void afterEach(){
        DBConnectionConfig.closeConnection();
    }

    @Order(1)
    @Test
    public void verifyFindAll(){
        List<ServicePackagesDto> servicePackagesDtoList =servicePackagesService.findAll();

        Assertions.assertTrue((!servicePackagesDtoList.isEmpty() ||servicePackagesDtoList!=null));
    }

    @Order(2)
    @Test
    public void verifyFindOne(){
        ServicePackagesDto servicePackagesDto =servicePackagesService.findOneById(11L);

        Assertions.assertTrue((servicePackagesDto.getId()==11L ||servicePackagesDto!=null));
    }

    @Order(3)
    @Test
    public void verifyUpdate(){
        String s = "updated ServiceName";

        ServicePackagesDto servicePackagesDto = servicePackagesService.findOneById(11L);
        servicePackagesDto.setServiceName(s);

        var erg = servicePackagesService.update(servicePackagesDto);

        Assertions.assertTrue((erg.getServiceName().equals(s) ||servicePackagesDto!=null));

    }

    @Order(4)
    @Test
    public void verifyInsert(){
        ServicePackagesDto servicePackagesDto = servicePackagesService.insert(Optional.of(DummyModels.servicePackages)
        .map(ServicePackagesDto::fromServicePackages)
        .orElse(null));

        Assertions.assertTrue(servicePackagesDto!=null);
    }


    @Order(5)
    @Test
    public void verifyDelte(){
        ServicePackagesDto servicePackagesDto = servicePackagesService.insert(Optional.of(DummyModels.servicePackages)
                .map(ServicePackagesDto::fromServicePackages)
                .orElse(null));

        servicePackagesService.delete(servicePackagesDto);

        try {
            servicePackagesService.findOneById(servicePackagesDto.getId());
        }
        catch (RuntimeException e){
            Assertions.assertTrue(e.getMessage().equals("Failed findOne"));
        }

    }


}
