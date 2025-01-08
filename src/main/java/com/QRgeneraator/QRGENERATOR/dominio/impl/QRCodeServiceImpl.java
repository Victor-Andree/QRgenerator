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
        return qrServOut.generateQRCode(request.getContent(), request.getWidth(), request.getHeight());
    }
}
