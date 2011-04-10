package com.foogaro.nojsf.restler.exception;

public class RestlerException extends Exception {

    public RestlerException(String msg) {
	    super(msg);
    }

    public RestlerException(String msg, Throwable e) {
	    super(msg, e);
    }

    public RestlerException(Throwable e) {
	    super(e);
    }

}
