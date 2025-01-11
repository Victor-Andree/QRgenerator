package com.QRgeneraator.QRGENERATOR.aplication.controller;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.WhatsAppDTO;
import com.QRgeneraator.QRGENERATOR.dominio.ports.in.WhatsAppServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsAppController {

    @Autowired
    WhatsAppServiceIn whatsAppServiceIn;

    @PostMapping("/sendWSP")
    public ResponseEntity<String> sendMessage(@RequestBody WhatsAppDTO request) {
        whatsAppServiceIn.sendMessage(request);
        return ResponseEntity.ok("Mensaje enviado correctamente");
    }
}
