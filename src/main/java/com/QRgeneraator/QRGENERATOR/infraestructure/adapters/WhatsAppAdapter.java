package com.QRgeneraator.QRGENERATOR.infraestructure.adapters;

import com.QRgeneraator.QRGENERATOR.configuration.WspConfiguration;
import com.QRgeneraator.QRGENERATOR.dominio.ports.out.WhatsAppServiceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class WhatsAppAdapter implements WhatsAppServiceOut {

    @Autowired
    private WspConfiguration wspConfiguration;

    @Override
    public void sendMessage(String number, String message) {
        try {
            String apiUrl = wspConfiguration.getApiUrl();
            String accessToken = wspConfiguration.getAccessToken();
            String fromNumber = wspConfiguration.getFromNumber(); // Número de origen

            /*System.out.println("Configuración de la API: ");
            System.out.println("URL de la API: " + apiUrl);
            System.out.println("Token de acceso: " + accessToken.substring(0, 10) + "****");
            System.out.println("Número de origen: " + fromNumber);
            System.out.println("Número destino: " + number);
            System.out.println("Mensaje a enviar: " + message);*/

            String messagePayload = "{"
                    + "\"messaging_product\": \"whatsapp\","
                    + "\"to\": \"" + number + "\","
                    + "\"type\": \"template\","
                    + "\"template\": {"
                    + "\"name\": \"hello_world\","
                    + "\"language\": {\"code\": \"en_US\"}"
                    + "}"
                    + "}";

            /*System.out.println("Cuerpo del mensaje en formato JSON: " + messagePayload);*/

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = messagePayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
            } else {
                try (InputStream is = connection.getErrorStream()) {
                    if (is != null) {
                        String errorResponse = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
