/**
 * 
 */
package com.vinaylogics.issuemanagement.doa.core.exceptions;

/**
 * @author vinay
 *
 */
public class CRUDException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214150637339613229L;
	
	
	public CRUDException(CrudErrorCode crudErrorCode) {
		super(crudErrorCode);
	}

}
