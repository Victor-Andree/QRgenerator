package com.QRgeneraator.QRGENERATOR.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter

@Component
public class WspConfiguration {

    private final String apiUrl = "https://graph.facebook.com/v21.0/559048567284546/messages";
    private final String accessToken = "EAAOSIxDjnN4BOxNqwcfuOSEEELihG8loTn5aXtagd4TPVYl6l1l87LTznVYvR6OIyyNYBanctN3ZAufE0a7ATmqnf2vbqU5LtZCePLaewAJohAHARerfIslwwC9hn8HNimnBAN5YDAJkevWPwJ4FByzQG3K8I5kUrypEbniw2HxcPlEpP0fP64mPB6c8aQmhoLKd1tzYuJbNN5zj1nYtOIEt4ZD";
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


