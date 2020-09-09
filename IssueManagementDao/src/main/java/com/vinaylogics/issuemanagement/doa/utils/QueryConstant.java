package com.vinaylogics.issuemanagement.doa.utils;

/**
 * This interface maintains all DML query for databases
 * 
 * 
 * 
 * @author vinay
 * @since 2020
 */
public interface QueryConstant {

	interface Database {
		String DB_NAME = "issue_management";
		String USER = "vinay";
		String PASSWORD = "drago";
		String HOST = "localhost";
		String PORT = "3306";

		default String createConnectionString(String dbName){
			return "jdbc:mysql://"+HOST+":"+PORT+"/"+dbName;
		}
	}

	interface BaseTable {
		String COL_ID = "ID";
		String COL_CREATED_AT = "CREATED_AT";
		String COL_UPDATED_AT = "UPDATED_AT";
	}

    interface UsersTable extends BaseTable{
		String TABLE_NAME = "users";

		String COL_NAME = "name";

		String Q_FIND_ALL = "SELECT * FROM " + TABLE_NAME+";";
		String Q_FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "=?;";
    }

    interface IssuesTable extends BaseTable{
		String TABLE_NAME = "issues";

		String COL_ISSUE = "issue";
		String COL_DESCRIPTION = "description";
		String COL_STATUS = "status";
		String COL_USER_ID = "user_id";

		String Q_FIND_ALL = "SELECT * FROM " + TABLE_NAME+";";
		String Q_FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "=?;";
    }
}
