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
    protected String findOneStatement() {
        return "SELECT servicepackageid, servicename, description, price FROM servicepackages WHERE servicepackageid=?";
    }

    @Override
    protected void bindPersistableFindOne(PreparedStatement preparedStatement,Long id) {
        try{
            preparedStatement.setLong(1,id);
           }
        catch (Exception e){
            throw new RuntimeException("Failed to bind servicePackage into findOne!! " , e);
        }
    }

    @Override
    protected Persistable mapFindOneToPersitable(ResultSet resultSet) {
        try {
            resultSet.next();
            Long id = resultSet.getLong("servicepackageid");
            String servicename = resultSet.getString("servicename");
            String description = resultSet.getString("description");
            Integer price = resultSet.getInt("price");
            if(resultSet.wasNull()) {
                price = null;
            }

            ServicePackages servicePackages = new ServicePackages(servicename,description,price);
            servicePackages.setId(id);
            return servicePackages;
        }
        catch (SQLException e){
            throw new RuntimeException("Failed to map Resultset servicePackage",e);
        }
    }

    @Override
    protected String updateStatement() {
        return "UPDATE servicepackages SET servicename= ? , description= ? , price= ? WHERE servicepackageid = ?";
    }

    @Override
    protected void bindPersistableUpdate(PreparedStatement preparedStatement, Persistable persistable) {
        ServicePackages servicePackages = (ServicePackages) persistable;
        try{
            preparedStatement.setString(1,servicePackages.getServiceName());
            preparedStatement.setString(2,servicePackages.getDescription());
            preparedStatement.setInt(3,servicePackages.getPrice());
            preparedStatement.setLong(4,servicePackages.getId());
        }
        catch (Exception e){
            throw new RuntimeException("Failed to bind servicePackage into update!! " , e);
        }
    }

    @Override
    public String insertStatement() {
        return "INSERT INTO servicepackages (servicename, description, price) " +
                "VALUES (?,?,?)";
    }

    @Override
    public void bindPersistableInsert(PreparedStatement preparedStatement, Persistable persistable) {
        ServicePackages servicePackages = (ServicePackages) persistable;
        try{
            preparedStatement.setString(1,servicePackages.getServiceName());
            preparedStatement.setString(2,servicePackages.getDescription());
            preparedStatement.setInt(3,servicePackages.getPrice());
        }
        catch (Exception e){
            throw new RuntimeException("Failed to bind servicePackage into insert!! " , e);
        }
    }

    @Override
    protected void bindPersistableDelete(PreparedStatement preparedStatement, Persistable persistable) {
        ServicePackages servicePackages = (ServicePackages) persistable;
        try{
            preparedStatement.setLong(1,servicePackages.getId());

        }
        catch (Exception e){
            throw new RuntimeException("Failed to bind servicePackage into delte!! " , e);
        }
    }

    @Override
    protected String deleteStatement() {
        return "DELETE FROM servicepackages where servicepackageid=?";
    }
}
