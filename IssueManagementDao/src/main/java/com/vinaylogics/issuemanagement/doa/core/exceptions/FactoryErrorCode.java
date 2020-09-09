package com.vinaylogics.issuemanagement.doa.core.exceptions;

public enum FactoryErrorCode implements ErrorCode{
    INVALID_FACTORY_TYPE(401,"Invalid Factory type supplied");

    private final int errorCode;
    private final String message;

    FactoryErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getName() {
        return "FactoryException";
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
