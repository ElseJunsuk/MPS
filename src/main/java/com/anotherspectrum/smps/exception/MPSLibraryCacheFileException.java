package com.anotherspectrum.smps.exception;

public class MPSLibraryCacheFileException extends RuntimeException {

    public MPSLibraryCacheFileException() {
        super();
    }

    public MPSLibraryCacheFileException(String message) {
        super(message);
    }

    public MPSLibraryCacheFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public MPSLibraryCacheFileException(Throwable cause) {
        super(cause);
    }

    protected MPSLibraryCacheFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
