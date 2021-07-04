package org.predjeskovic.solutionCompany.presentation;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.predjeskovic.solutionCompany.config.DBConnectionConfig;
import org.predjeskovic.solutionCompany.service.ServicePackagesDto;
import org.predjeskovic.solutionCompany.service.ServicePackagesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/packages/create")
public class ServicePackageCreateServlet extends HttpServlet {

    private ServicePackagesService servicePackagesService;

    private DataSource dataSource = DBConnectionConfig.getDataSource();

    public ServicePackageCreateServlet(){
        try {

            this.servicePackagesService = new ServicePackagesService(dataSource.getConnection());
        }
        catch (SQLException e){
            throw new RuntimeException("Db connection failed",e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/servicePackages/create.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServicePackagesDto servicePackagesDto = new ServicePackagesDto();

        servicePackagesDto.setServiceName(req.getParameter("serviceName"));
        servicePackagesDto.setDescription(req.getParameter("description"));
        servicePackagesDto.setPrice(Integer.parseInt(req.getParameter("price")));

        servicePackagesService.insert(servicePackagesDto);


        resp.sendRedirect("/ITSolutionCompany_war/packages/view");


    }
}
