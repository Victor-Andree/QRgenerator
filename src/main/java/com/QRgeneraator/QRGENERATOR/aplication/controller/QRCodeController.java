package com.QRgeneraator.QRGENERATOR.aplication.controller;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.QRCode;
import com.QRgeneraator.QRGENERATOR.dominio.ports.in.QRServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    @Autowired
    QRServIn qrServIn;

    @GetMapping("/generate-qr")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String content,
                                                 @RequestParam(defaultValue = "100") int width,
                                                 @RequestParam(defaultValue = "100") int height) {
        QRCode request = new QRCode(content, width, height);
        byte[] qrCode = qrServIn.generateQRCode(request);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/png");

        return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
    }
}
