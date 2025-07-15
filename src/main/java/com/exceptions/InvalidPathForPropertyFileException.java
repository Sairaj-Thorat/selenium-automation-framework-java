package com.exceptions;

public class InvalidPathForPropertyFileException extends InvalidPathForFileException {

    public InvalidPathForPropertyFileException(String message) {
        super(message);
    }

    public InvalidPathForPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
