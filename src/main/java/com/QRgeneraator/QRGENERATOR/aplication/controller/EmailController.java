package com.QRgeneraator.QRGENERATOR.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;


    @PostMapping("EnviarCorreo")
    public ResponseEntity<?> send_email() {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom("CORREOQUEENVIAve");
        email.setTo("CORREODEDESTINO");
        email.setSubject("Mensaje de Prueba 1");
        email.setText("NO RESPONDER");

        mailSender.send(email);

        return  new ResponseEntity<>(true, HttpStatus.OK);


    }


}
