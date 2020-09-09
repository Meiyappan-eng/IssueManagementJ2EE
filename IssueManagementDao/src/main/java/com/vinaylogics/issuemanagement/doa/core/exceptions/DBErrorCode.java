package com.vinaylogics.issuemanagement.doa.core.exceptions;

public enum DBErrorCode implements ErrorCode{
    CONNECTION_ERROR(101, "Connection Error");
	
	private final int errorCode;
	private final String message;
	
	DBErrorCode(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getError() {
        return errorCode;
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DB Exception";
	}
    
    
}
