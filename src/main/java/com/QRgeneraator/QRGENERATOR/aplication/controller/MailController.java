package com.QRgeneraator.QRGENERATOR.aplication.controller;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.EmailDTO;
import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.EmailFileDTO;
import com.QRgeneraator.QRGENERATOR.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class MailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/EnviarCorreo")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("Mensaje Enviado"+ emailDTO);

        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return  ResponseEntity.ok(response);

    }

    @PostMapping("/EnviarCorreoArchivo")
    public ResponseEntity<?> receiveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO){

        try {
            String FileName = emailFileDTO.getFile().getOriginalFilename();

            Path path = Paths.get("src/mail/resource/files/" + FileName);

            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailWithFile(emailFileDTO.getToUser(),emailFileDTO.getSubject(),emailFileDTO.getMessage(),file);


            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            response.put("archivo", "fileName");

            return ResponseEntity.ok(response);



        } catch (Exception e){
            throw new RuntimeException("Error al enviar el mensaje con el archivo" + e.getMessage());
        }

    }


}
