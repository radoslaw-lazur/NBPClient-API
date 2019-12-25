package com.crud.nbpclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Component
public class ClientNbp {
    @Autowired
    private RestTemplate restTemplate;

    public String getStringJsonChf() {
        return restTemplate.getForObject(getJsonNbpCHF(), String.class);
    }

    public String getStringJsonEur() {
        return restTemplate.getForObject(getJsonNbpEUR(), String.class);
    }

    public String getStringJsonGbp() {
        return restTemplate.getForObject(getJsonNbpGBP(), String.class);
    }

    private URI getJsonNbpCHF() {
        return UriComponentsBuilder.fromHttpUrl("http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=json")
                .build().encode().toUri();
    }

    private URI getJsonNbpEUR() {
        return UriComponentsBuilder.fromHttpUrl("http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json")
                .build().encode().toUri();
    }

    private URI getJsonNbpGBP() {
        return UriComponentsBuilder.fromHttpUrl("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json")
                .build().encode().toUri();
    }
}
