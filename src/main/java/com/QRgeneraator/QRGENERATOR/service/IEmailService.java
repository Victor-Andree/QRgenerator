package com.QRgeneraator.QRGENERATOR.service;

import java.io.File;

public interface IEmailService {

    void sendEmail(String[] toUser , String subject , String message);

    void sendEmailWithFile(String[] toUser, String subject , String message, File file);
}
