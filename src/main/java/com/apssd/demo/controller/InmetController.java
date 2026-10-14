
package com.apssd.demo.controller;

import com.apssd.demo.service.AvisoInmetService;
import tools.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InmetController {

    private final AvisoInmetService avisoInmetService;

    public InmetController(AvisoInmetService avisoInmetService) {
        this.avisoInmetService = avisoInmetService;
    }

    @GetMapping("/inmet/avisos/ativos")
    public JsonNode listarAvisosAtivos() {
        return avisoInmetService.buscarAvisosAtivos();
    }
}
