package base.controllers;

import base.controllers.api.soap.generatedForExample.TemperatureRequest;
import base.controllers.api.soap.generatedForExample.TemperatureResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by StefanS on 29.04.2016.
 */
@Endpoint(value = "/temperature")
public class TemperatureEndpoint {

    @PayloadRoot(localPart = "TemperatureRequest", namespace = "http://www.example.org/TemperatureRequest")
    public @ResponsePayload
    TemperatureResponse convertToFahrenheit(@RequestPayload TemperatureRequest request) {
        int celsius=request.getCelsius();
        int fahrenheit=(int) ((1.8*celsius)+32);
        TemperatureResponse response=new TemperatureResponse();
        response.setFahrenheit(fahrenheit);
        return response;
    }
}
