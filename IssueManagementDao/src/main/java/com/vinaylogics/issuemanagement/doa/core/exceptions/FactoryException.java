package com.vinaylogics.issuemanagement.doa.core.exceptions;

public class FactoryException extends BaseException{

    public FactoryException(FactoryErrorCode errorCode) {
        super(errorCode);
    }
}
