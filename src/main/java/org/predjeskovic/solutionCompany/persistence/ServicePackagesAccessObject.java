package org.predjeskovic.solutionCompany.persistence;

import org.predjeskovic.solutionCompany.model.Persistable;
import org.predjeskovic.solutionCompany.model.ServicePackages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicePackagesAccessObject extends AbstractDataAccessObject{


    public ServicePackagesAccessObject(Connection connection) {
        super(connection);
    }

    @Override
    protected String selectStatement() {
        return "SELECT servicepackageid, servicename, description, price FROM servicepackages";
    }

    @Override
    protected Persistable mapResultSetToPersistable(ResultSet resultSet) {
        try{
            Long id = resultSet.getLong("servicepackageid");
            String servicename = resultSet.getString("servicename");
            String description = resultSet.getString("description");
            Integer price = resultSet.getInt("price");

            ServicePackages servicePackage = new ServicePackages(servicename,description,price);

            servicePackage.setId(id);
            return servicePackage;

        }
        catch (SQLException e){
            throw new RuntimeException("Failed to map Resultset servicePackage",e);
        }
    }

    @Override
    protected String updateStatement() {
        return null;
    }

    @Override
    protected void bindPersistableUpdate(PreparedStatement preparedStatement, Persistable persistable) {

    }

    @Override
    public String insertStatement() {
        return null;
    }

    @Override
    public void bindPersistableInsert(PreparedStatement preparedStatement, Persistable persistable) {

    }

    @Override
    protected void bindPersistableDelete(PreparedStatement preparedStatement, Persistable persistable) {

    }

    @Override
    protected String deleteStatement() {
        return null;
    }
}
