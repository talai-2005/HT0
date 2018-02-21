package com.nikolay.design.exception;

public class SpaceUsageTooMuchException extends Exception {

    public SpaceUsageTooMuchException() {
        super();
    }

    public SpaceUsageTooMuchException(String message) {
        super(message);
    }

    public SpaceUsageTooMuchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpaceUsageTooMuchException(Throwable cause) {
        super(cause);
    }
}
