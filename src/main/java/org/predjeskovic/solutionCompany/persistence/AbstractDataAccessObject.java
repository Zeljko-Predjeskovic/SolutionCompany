package org.predjeskovic.solutionCompany.persistence;


import org.predjeskovic.solutionCompany.model.Persistable;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDataAccessObject <T extends Persistable>{


    private final Connection connection;

    public AbstractDataAccessObject(Connection connection){
        this.connection=connection;
    }

    public List<T> findAll(){
        List<T> persistables = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                persistables.add(mapResultSetToPersistable(resultSet));
            }
        }
        catch (SQLException e){
            throw new RuntimeException("Failed to execute SELECT for findAll",e);
        }
        return persistables;

    }

    protected abstract String selectStatement();

    protected abstract T mapResultSetToPersistable(ResultSet resultSet);

    public Optional<T> findOne(Long id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(findOneStatement());
            bindPersistableFindOne(preparedStatement,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return Optional.of(mapFindOneToPersitable(resultSet));
        }
        catch (Exception e){
            throw new RuntimeException("Failed findOne", e);
        }
    }

    protected abstract String findOneStatement();

    protected abstract void bindPersistableFindOne(PreparedStatement preparedStatement, Long id);

    protected abstract T mapFindOneToPersitable(ResultSet resultSet);

    public T update(T persistable) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatement(), Statement.RETURN_GENERATED_KEYS);
            bindPersistableUpdate(preparedStatement, persistable);
            int rows = preparedStatement.executeUpdate();
            if(rows != 1){
                throw new RuntimeException("Too many rows, update stopped");
            }

        }
        catch(SQLException e) {
            throw new RuntimeException("Failed update", e);
        }
        return persistable;
    }

    protected abstract String updateStatement();

    protected abstract void bindPersistableUpdate(PreparedStatement preparedStatement, T persistable);

    public T insert(T persistable) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement(), Statement.RETURN_GENERATED_KEYS);
            bindPersistableInsert(preparedStatement, persistable);
            int rows = preparedStatement.executeUpdate();
            if (rows!=1){
                throw new RuntimeException("To many rows inserted");
            }
            Long id = null;
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while(generatedKeys.next()){
                id = generatedKeys.getLong(1);
            }
            persistable.setId(id);
        }
        catch (SQLException e){
            throw new RuntimeException("Insert ServicePackage failed", e);
        }
        return persistable;
    }

    public abstract String insertStatement();

    public abstract void bindPersistableInsert(PreparedStatement preparedStatement, T persistable);

    public T delete(T persistable){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement());
            bindPersistableDelete(preparedStatement, persistable);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException("Delete failed", e);
        }
        return persistable;
    }

    protected abstract void bindPersistableDelete(PreparedStatement preparedStatement, T persistable);

    protected abstract String deleteStatement();

}
