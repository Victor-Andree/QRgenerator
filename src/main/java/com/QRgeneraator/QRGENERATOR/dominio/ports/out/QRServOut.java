package com.QRgeneraator.QRGENERATOR.dominio.ports.out;

public interface QRServOut {
    byte[] generateQRCode(String content, int width, int height);

}
