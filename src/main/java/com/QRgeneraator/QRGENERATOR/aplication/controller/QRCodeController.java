package com.QRgeneraator.QRGENERATOR.aplication.controller;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.QRCode;
import com.QRgeneraator.QRGENERATOR.dominio.ports.in.QRServIn;
import com.QRgeneraator.QRGENERATOR.exceptions.QRExcepcionts.QRCodeGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QRCodeController {

    @Autowired
    QRServIn qrServIn;

    @PostMapping("/generate-qr")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody QRCode request) {
        try {
            byte[] qrCode = qrServIn.generateQRCode(request);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "image/png");
            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (QRCodeGenerationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
