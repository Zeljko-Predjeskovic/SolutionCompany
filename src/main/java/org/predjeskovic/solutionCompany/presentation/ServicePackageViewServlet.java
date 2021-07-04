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
import java.util.List;

@WebServlet(urlPatterns = "/packages/view")
public class ServicePackageViewServlet extends HttpServlet {

    private ServicePackagesService servicePackagesService;

    private DataSource dataSource = DBConnectionConfig.getDataSource();

    public ServicePackageViewServlet(){
        try {

            this.servicePackagesService = new ServicePackagesService(dataSource.getConnection());
        }
        catch (SQLException e){
            throw new RuntimeException("Db connection failed",e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ServicePackagesDto> servicePackagesDtoList = servicePackagesService.findAll();


        servicePackagesDtoList.sort((f1,f2) -> f1.getPrice() - f2.getPrice());

        req.setAttribute("packages",servicePackagesDtoList);
        req.getRequestDispatcher("/servicePackages/view.jsp").forward(req, resp);

    }


}
