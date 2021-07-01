package org.predjeskovic.solutionCompany.presentation;

import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.service.ServicePackagesDto;
import org.predjeskovic.solutionCompany.service.ServicePackagesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/packages/view")
public class ServicePackageViewServlet extends HttpServlet {

    private ServicePackagesService servicePackagesService;

    public ServicePackageViewServlet() {
        this.servicePackagesService = new ServicePackagesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ServicePackagesDto> servicePackagesDtoList = servicePackagesService.findAll();

        req.setAttribute("packages",servicePackagesDtoList);
        req.getRequestDispatcher("/servicePackages/view.jsp").forward(req, resp);

    }


}
