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

@WebServlet(urlPatterns = "/packages/edit/*")
public class ServicePackageEditServlet extends HttpServlet {

    private ServicePackagesService servicePackagesService;

    private DataSource dataSource = DBConnectionConfig.getDataSource();

    public ServicePackageEditServlet(){
        try {

            this.servicePackagesService = new ServicePackagesService(dataSource.getConnection());
        }
        catch (SQLException e){
            throw new RuntimeException("Db connection failed",e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] s = req.getPathInfo().split("/");

        Long id = Long.parseLong(s[1]);

        ServicePackagesDto servicePackagesDto = servicePackagesService.findOneById(id);



        req.setAttribute("package",servicePackagesDto);
        req.getRequestDispatcher("/servicePackages/edit.jsp").forward(req, resp);

    }
}
