package com.QRgeneraator.QRGENERATOR.dominio.ports.in;
import com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto.QRCode;


public interface QRServIn {
    byte[] generateQRCode(QRCode request);
}
