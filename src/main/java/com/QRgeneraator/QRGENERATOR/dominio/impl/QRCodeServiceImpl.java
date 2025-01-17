package com.QRgeneraator.QRGENERATOR.dominio.impl;

import com.QRgeneraator.QRGENERATOR.dominio.ports.in.QRServIn;
import com.QRgeneraator.QRGENERATOR.dominio.ports.out.QRServOut;
import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QRCodeServiceImpl implements QRServIn {

    @Autowired
    private QRServOut qrServOut;

    @Override
    public byte[] generateQRCode(QRCode request) {
        if (request.getContent() == null || request.getContent().isEmpty()) {
            throw new IllegalArgumentException("El contenido del código QR no puede ser nulo o vacío");
        }

        if (request.getWidth() <= 0 || request.getHeight() <= 0) {
            throw new IllegalArgumentException("Las dimensiones del código QR deben ser mayores que cero");
        }

        return qrServOut.generateQRCode(request.getContent(), request.getWidth(), request.getHeight());
    }

}
