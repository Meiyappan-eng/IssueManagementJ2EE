package com.vinaylogics.issuemanagement.doa.factory;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;
import com.vinaylogics.issuemanagement.doa.core.exceptions.CRUDException;
import com.vinaylogics.issuemanagement.doa.core.exceptions.CrudErrorCode;
import com.vinaylogics.issuemanagement.doa.core.manager.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementConnection extends JDBCConnectionFactory {

    public PreparedStatementConnection() {
        super(ConnectionManager.getInstance(DB_NAME));
    }

    @Override
    public <T,R> R executeQuery(String sql, ExecuteQueryCallback<R> callback, T... objects) throws BaseException {
        try(Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < objects.length; i++) {
                statement.setString(i+1, String.valueOf(objects[i]));
            }
            return callback.execute(statement.executeQuery());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            throw new CRUDException(CrudErrorCode.FIND_ERROR);
        }

    }

    @Override
    public <T extends Number> T executeUpdate(String sql, ExecuteUpdateCallback<T> callback, T... objects)throws BaseException {
        try(Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < objects.length; i++) {
                statement.setString(i+1, String.valueOf(objects[i]));
            }
            statement.executeUpdate();
            return callback.execute();
        } catch (SQLException exception) {
            throw new CRUDException(CrudErrorCode.FIND_ERROR);
        }
    }
}
