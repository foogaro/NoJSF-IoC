package com.foogaro.nojsf.persistence.exception;

public class PersistenceException extends Exception {

    public PersistenceException(String msg) {
	    super(msg);
    }

    public PersistenceException(String msg, Throwable e) {
	    super(msg, e);
    }

    public PersistenceException(Throwable e) {
	    super(e);
    }
}
