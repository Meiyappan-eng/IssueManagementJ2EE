package com.vinaylogics.issuemanagement.doa.core.exceptions;

public class DBException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3757403006174024525L;

	public DBException(DBErrorCode dbErrorCode) {
        super(dbErrorCode);
    }
}
