package com.QRgeneraator.QRGENERATOR.dominio.impl;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.WhatsAppDTO;
import com.QRgeneraator.QRGENERATOR.dominio.ports.in.WhatsAppServiceIn;
import com.QRgeneraator.QRGENERATOR.dominio.ports.out.WhatsAppServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppServiceIn {

    @Autowired
    WhatsAppServiceOut whatsAppServiceOut;


    @Override
    public void sendMessage(WhatsAppDTO request) {
        String number = request.getNumber();
        whatsAppServiceOut.sendMessage(number);
    }
}
