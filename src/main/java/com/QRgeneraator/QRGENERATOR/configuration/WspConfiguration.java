package com.QRgeneraator.QRGENERATOR.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter

@Component
public class WspConfiguration {

    private final String apiUrl = "https://graph.facebook.com/v21.0/559048567284546/messages";
    private final String accessToken = "EAAOSIxDjnN4BO5YcO0EdKKpmzQOdeWlippB7eqgjkdE1JfPG5GnDsOk6HjvibYJ5ALjKKJGza8vacVLLZBgmalZA4zVpp1IFDDHJZAxU4HRJ2UJekPyVTDNyCZCxqc9eejLtUAOoX9v2ZBLRPZBZAxXtl0pj0KiP6hr5F0y0voj8maK8zXuFm8sghPHJSK5TrlozgiTmr9xI3EsZBTP9ZCflkPoZAwkk4ZD";
    private final String fromNumber = "whatsapp:+15551756597";

    public String getApiUrl() {
        return apiUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getFromNumber() {
        return fromNumber;
    }
}


