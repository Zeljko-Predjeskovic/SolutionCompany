package org.predjeskovic.solutionCompany.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServicePackagesServiceTest {

    private ServicePackagesService servicePackagesService = new ServicePackagesService();

    @Test
    public void verifyFindAll(){
        List<ServicePackagesDto> servicePackagesDtoList =servicePackagesService.findAll();

        for(ServicePackagesDto e : servicePackagesDtoList){
            System.out.println(e);
        }

        Assertions.assertTrue((!servicePackagesDtoList.isEmpty() ||servicePackagesDtoList!=null));
    }
}
