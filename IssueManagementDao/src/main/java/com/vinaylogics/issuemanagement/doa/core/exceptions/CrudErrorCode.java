package com.vinaylogics.issuemanagement.doa.core.exceptions;

public enum CrudErrorCode implements ErrorCode {
    SAVE_ERROR(104, "Error in saving data"),
	FIND_ERROR(105, "Error in retrieving the data");

	private final int errorCode;
	private final String message;
	CrudErrorCode(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
    @Override
	public String getName() {
		return "CRUD Exception";
	}

	@Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getError() {
        return errorCode;
    }
}
