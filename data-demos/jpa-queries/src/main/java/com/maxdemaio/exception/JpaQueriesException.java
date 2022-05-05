package com.maxdemaio.exception;

public class JpaQueriesException extends Exception {
    private static final long serialVersionUID = 1572701266102829073L;

    public JpaQueriesException(String errorMessage) {
        super(errorMessage);
    }

}
