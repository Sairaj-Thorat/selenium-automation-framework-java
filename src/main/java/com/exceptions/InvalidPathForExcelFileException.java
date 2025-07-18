package com.exceptions;

public class InvalidPathForExcelFileException extends InvalidPathForFileException {

    public InvalidPathForExcelFileException(String message) {
        super(message);
    }

    public InvalidPathForExcelFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
