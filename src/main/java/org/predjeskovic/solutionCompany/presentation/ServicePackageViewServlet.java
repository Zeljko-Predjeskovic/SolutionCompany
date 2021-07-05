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
import java.util.Comparator;
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



        req.setAttribute("packages",searchBar(req.getParameter("searchbar")));
        System.out.println(req.getParameter("searchbar"));
        req.getRequestDispatcher("/servicePackages/view.jsp").forward(req, resp);

    }


    protected List<ServicePackagesDto> searchBar(String s){
        List<ServicePackagesDto> servicePackagesDtoList = servicePackagesService.findAll();

        if(s==null || s.isEmpty()){
            servicePackagesDtoList.sort((f1,f2) -> f1.getPrice() - f2.getPrice());
        }
        else{
            servicePackagesDtoList.sort((o1, o2) -> {

                boolean a1 = o1.getServiceName().contains(s);

                boolean a2 = o2.getServiceName().contains(s);

                if(a1 && a2)
                    return o1.getServiceName().compareTo(o2.getServiceName());

                if(a1)
                    return -1;

                if(a2)
                    return 1;
                return 0;
            }
                    );
        }
        return servicePackagesDtoList;

    }


}
