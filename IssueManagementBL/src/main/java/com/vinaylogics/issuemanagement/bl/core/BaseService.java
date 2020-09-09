package com.vinaylogics.issuemanagement.bl.core;

import com.vinaylogics.issuemanagement.doa.core.exceptions.BaseException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends Serializable, ID extends Number> {

    List<T> findAll() throws BaseException;

    Optional<T> findById(ID id) throws BaseException;

    T save(T t) throws BaseException;

    T update(T t, ID id) throws BaseException;

    void delete(T t) throws BaseException;

    void deleteById(ID id) throws BaseException;
}
