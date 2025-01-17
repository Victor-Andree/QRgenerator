package com.QRgeneraator.QRGENERATOR.exceptions.QRExcepcionts;

public class QRCodeGenerationException extends RuntimeException {
    public QRCodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public QRCodeGenerationException(String message) {
        super(message);
    }
}
