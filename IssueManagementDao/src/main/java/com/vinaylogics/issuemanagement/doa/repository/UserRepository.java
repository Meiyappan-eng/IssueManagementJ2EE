package com.vinaylogics.issuemanagement.doa.repository;

import com.vinaylogics.issuemanagement.doa.core.BaseDao;
import com.vinaylogics.issuemanagement.doa.models.User;
import com.vinaylogics.issuemanagement.doa.utils.QueryConstant;

/**
 * This interface handles transaction between user table and dao
 * @see BaseDao
 */
public interface UserRepository extends BaseDao<User,Integer>, QueryConstant.UsersTable{
}
