package com.QRgeneraator.QRGENERATOR.MailExceptions;

import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MailExceptionHandler {

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<MailExceptions> handleMessagingException(MessagingException  ex) {
        MailExceptions mailExceptions = new MailExceptions("Error al enviar el correo", ex.getMessage());
        return new ResponseEntity<>(mailExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<MailExceptions> handleIOException(IOException ex) {
        MailExceptions mailExceptions = new MailExceptions("Error al enviar el correo", ex.getMessage());
        return new ResponseEntity<>(mailExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MailExceptions> handleRuntimeException(RuntimeException ex) {
        MailExceptions mailExceptions = new MailExceptions("Error al enviar el correo", ex.getMessage());
        return new ResponseEntity<>(mailExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MailExceptions> handleException(Exception ex) {
        MailExceptions mailExceptions = new MailExceptions("Error al enviar el correo", ex.getMessage());
        return new ResponseEntity<>(mailExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
