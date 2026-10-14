
package com.apssd.demo.service;

import tools.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AvisoInmetService {

    private final RestClient restClient = RestClient.create();

    public JsonNode buscarAvisosAtivos() {
        return restClient.get()
                .uri("https://apiprevmet3.inmet.gov.br/avisos/ativos")
                .retrieve()
                .body(JsonNode.class);
    }
}
