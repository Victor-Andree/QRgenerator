package com.QRgeneraator.QRGENERATOR.dominio.aggretes.dto;

public class QRCode {
    private String content;
    private int width;
    private int height;

    public QRCode() {}

    public QRCode(String content, int width, int height) {
        this.content = content;
        this.width = width;
        this.height = height;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
