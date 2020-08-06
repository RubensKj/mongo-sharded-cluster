package com.rubenskj.config.exception;

public class DocumentCodecException extends RuntimeException {
    public DocumentCodecException() {
    }

    public DocumentCodecException(String message) {
        super(message);
    }

    public DocumentCodecException(String message, Throwable cause) {
        super(message, cause);
    }
}
