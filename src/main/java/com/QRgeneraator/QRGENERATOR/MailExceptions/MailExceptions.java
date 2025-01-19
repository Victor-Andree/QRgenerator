package com.QRgeneraator.QRGENERATOR.MailExceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class MailExceptions {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public MailExceptions(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
}

