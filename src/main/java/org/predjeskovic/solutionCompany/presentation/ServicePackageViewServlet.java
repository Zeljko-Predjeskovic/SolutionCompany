package org.predjeskovic.solutionCompany.presentation;

import org.predjeskovic.solutionCompany.service.ServicePackagesService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/packages/view", name = "servicePackageViewServlet" )
public class ServicePackageViewServlet extends HttpServlet {

    private final ServicePackagesService servicePackagesService = new ServicePackagesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){


    }


}
