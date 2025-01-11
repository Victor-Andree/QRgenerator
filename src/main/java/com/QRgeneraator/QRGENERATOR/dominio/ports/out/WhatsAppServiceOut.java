package com.QRgeneraator.QRGENERATOR.dominio.ports.out;


public interface WhatsAppServiceOut {
    void sendMessage(String number, String message);
}
