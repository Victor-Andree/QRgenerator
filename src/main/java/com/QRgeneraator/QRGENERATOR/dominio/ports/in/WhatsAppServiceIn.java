package com.QRgeneraator.QRGENERATOR.dominio.ports.in;

import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.WhatsAppDTO;

public interface WhatsAppServiceIn {
    void sendMessage(WhatsAppDTO request);
}
