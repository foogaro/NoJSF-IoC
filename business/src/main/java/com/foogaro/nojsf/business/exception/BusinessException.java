package com.foogaro.nojsf.business.exception;

public class BusinessException extends Exception {

    public BusinessException(String msg) {
	    super(msg);
    }

    public BusinessException(String msg, Throwable e) {
	    super(msg, e);
    }

    public BusinessException(Throwable e) {
	    super(e);
    }
}
