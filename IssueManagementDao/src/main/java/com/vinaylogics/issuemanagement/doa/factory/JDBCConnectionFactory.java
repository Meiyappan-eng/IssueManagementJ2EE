/**
 * 
 */
package com.vinaylogics.issuemanagement.doa.factory;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;
import com.vinaylogics.issuemanagement.doa.core.exceptions.DBErrorCode;
import com.vinaylogics.issuemanagement.doa.core.exceptions.DBException;
import com.vinaylogics.issuemanagement.doa.core.manager.ConnectionManager;
import com.vinaylogics.issuemanagement.doa.utils.QueryConstant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * @author vinay
 *
 */
public abstract class JDBCConnectionFactory implements QueryConstant.Database {

    protected ConnectionManager connectionManager;
    protected Connection connection;

    public JDBCConnectionFactory(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @FunctionalInterface
    public interface ExecuteQueryCallback <T>{
        T execute(ResultSet result) throws BaseException, SQLException;
    }

    @FunctionalInterface
    public interface ExecuteUpdateCallback<T extends Number>{
       T execute() throws BaseException;
    }
    Connection openConnection() throws BaseException {
        try {
            connection = connectionManager.getConnection();
            return connection;
        } catch (SQLException exception) {
            throw new DBException(DBErrorCode.CONNECTION_ERROR);
        }
    }

    abstract public <T, R> R executeQuery(String sql, ExecuteQueryCallback<R> callback, T... t) throws BaseException;
    abstract public <T extends Number> T executeUpdate(String sql,ExecuteUpdateCallback<T> callback ,T... t) throws BaseException;

}
