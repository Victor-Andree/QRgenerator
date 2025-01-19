package com.QRgeneraator.QRGENERATOR.aplication.controller;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.EmailDTO;
import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.EmailFileDTO;
import com.QRgeneraator.QRGENERATOR.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
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
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO) {
        try {
            emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al enviar el correo: " + e.getMessage());
        }
    }

    @PostMapping("/EnviarCorreoArchivo")
    public ResponseEntity<?> sendEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO) {
        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/mail/resource/files/" + fileName);

            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailWithFile(emailFileDTO.getToUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);

            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            response.put("archivo", fileName);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            throw new RuntimeException("Error al procesar el archivo adjunto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado: " + e.getMessage());
        }
    }


}
