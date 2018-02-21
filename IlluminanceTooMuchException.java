package com.nikolay.design.exception;

public class IlluminanceTooMuchException extends Exception {

    public IlluminanceTooMuchException() {
        super();
    }

    public IlluminanceTooMuchException(String message) {
        super(message);
    }

    public IlluminanceTooMuchException(String message, Throwable cause) {
        super(message, cause);
    }

    public IlluminanceTooMuchException(Throwable cause) {
        super(cause);
    }
}
