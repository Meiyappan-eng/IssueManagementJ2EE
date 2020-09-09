package com.vinaylogics.issuemanagement.doa.core.exceptions;

/**
 * This is common exception class for our Database layer
 * @author vinay
 * @see ErrorCode
 *
 */
public abstract class BaseException extends Exception implements ErrorCode{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4023205703168549143L;
	private final ErrorCode errorCode;

    protected BaseException(ErrorCode errorCode) {
    	super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode(){
        return errorCode;
    }
    

    @Override
    public String getMessage(){
        return errorCode.getMessage();
    }

    @Override
    public int getError(){
        return errorCode.getError();
    }

	@Override
	public String getName() {
		return errorCode.getMessage();
	}
    
    
}
