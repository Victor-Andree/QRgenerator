package com.QRgeneraator.QRGENERATOR.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter

@Component
public class WspConfiguration {

    /*URL DEL NÚMERO DE PRUEBA*/
    private final String apiUrl = "https://graph.facebook.com/v21.0/559048567284546/messages";

    /*NÚMERO DESDE DONDE SE ENVIARÁ EL MENSAJE*/
    private final String fromNumber = "whatsapp:+15551756597";


//    private final String apiUrl = "https://graph.facebook.com/v21.0/524427240755536/messages";
//    private final String fromNumber = "whatsapp:+51904643048";


    /*NO BORRAR ESTE TOKEN PORQUE ES PERMANENTE SIN EXPIRACIÓN*/
    private final String accessToken = "EAAOSIxDjnN4BO5PlQIxTol5XCNy0xASVNfdSOCsqB3ZByYGf7g8twUX2pP6rX8sLKyK6riAa9ZC4wtzPPXyLWpZCXtDQHMYEk8nkQc8Hb35CeotZCzE5xe5pJZAthf7763ngBEbnFcR1kvw2Rl7M3CJ3HmOZA7lnoynCY4UGfbBnWLui83tW1Qtt4VowsRZBnfk4gZDZD";



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


