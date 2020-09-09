package com.vinaylogics.issuemanagement.doa.factory;


import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;
import com.vinaylogics.issuemanagement.doa.core.exceptions.FactoryErrorCode;
import com.vinaylogics.issuemanagement.doa.core.exceptions.FactoryException;

public class ConnectionFactory {

    public enum Type {
        STATEMENT,
        PREPARED_STATEMENT,
        CALLABLE_STATEMENT
    }

    private ConnectionFactory(){

    }

    public static JDBCConnectionFactory createConnection(Type type) throws BaseException {
        JDBCConnectionFactory connectionFactory;
        switch (type){
            case PREPARED_STATEMENT:
                connectionFactory = new PreparedStatementConnection();
                break;
            default:
                throw new FactoryException(FactoryErrorCode.INVALID_FACTORY_TYPE);
        }

        return connectionFactory;
    }
}
