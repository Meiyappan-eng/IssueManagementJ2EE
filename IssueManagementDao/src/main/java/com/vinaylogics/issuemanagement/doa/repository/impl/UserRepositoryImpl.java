package com.vinaylogics.issuemanagement.doa.repository.impl;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;
import com.vinaylogics.issuemanagement.doa.factory.ConnectionFactory;
import com.vinaylogics.issuemanagement.doa.factory.JDBCConnectionFactory;
import com.vinaylogics.issuemanagement.doa.models.User;
import com.vinaylogics.issuemanagement.doa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    JDBCConnectionFactory connection;

    public UserRepositoryImpl() throws BaseException {
        this.connection = ConnectionFactory.createConnection(ConnectionFactory.Type.PREPARED_STATEMENT);
    }

    @Override
    public List<User> findAll() throws BaseException {
       return connection.executeQuery(Q_FIND_ALL, (result -> {
           List<User> users = new ArrayList<>();
           while (result.next()){
               users.add(
                       new User(
                               result.getLong(COL_ID),
                               result.getTimestamp(COL_CREATED_AT).toLocalDateTime(),
                               result.getTimestamp(COL_UPDATED_AT).toLocalDateTime(),
                               result.getString(COL_NAME)
                       )
               );
           }
           return users;
       }));
    }

    @Override
    public Optional<User> findById(Integer id) throws BaseException {
        return connection.executeQuery(Q_FIND_BY_ID, (result ->{
            if(result.next()){
                return Optional.of(
                        new User(
                                result.getLong(COL_ID),
                                result.getTimestamp(COL_CREATED_AT).toLocalDateTime(),
                                result.getTimestamp(COL_UPDATED_AT).toLocalDateTime(),
                                result.getString(COL_NAME)
                        )
                );
            }
            return Optional.empty();
        }), id);
    }

    @Override
    public User save(User t) throws BaseException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User update(User t, Integer id) throws BaseException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(User t) throws BaseException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteById(Integer id) throws BaseException {
        // TODO Auto-generated method stub
        return false;
    }

}
