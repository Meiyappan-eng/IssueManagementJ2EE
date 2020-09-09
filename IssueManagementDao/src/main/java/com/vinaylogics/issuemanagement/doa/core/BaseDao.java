package com.vinaylogics.issuemanagement.doa.core;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * This is the core interface to maintain common BL of accessing database
 * @param <T> is the model class which table
 * @param <ID> is the unique key
 *
 * @see Serializable
 * @see Number
 * @see BaseException
 *
 * @author vinay
 *
 * @since 2020
 */
public interface BaseDao<T extends Serializable, ID extends Number> {

    /**
     * To get all the values from the table
     *
     * @see List
     *
     * @return java.util.List
     * @throws BaseException : error database
     */
    List<T> findAll() throws BaseException;

    /**
     * To get Object based on id primary key
     * @param id : unique id for the table
     *
     * @see Optional
     *
     * @return found object
     * @throws BaseException : error in database
     */
    Optional<T> findById(ID id) throws BaseException;

    /**
     * This method to save object to the database
     * @param t: object to saved on database
     * @return saved object
     * @throws BaseException : error in database
     */
    T save(T t) throws BaseException;

    /**
     * This methods Updates the object based on ID
     * @param t : Object to be Updated
     * @param id : Primary key of the table row
     * @return updated object
     * @throws BaseException : error in data base
     */
     T update(T t, ID id) throws BaseException;

     boolean delete(T t) throws BaseException;

     boolean deleteById(ID id) throws BaseException;
}
