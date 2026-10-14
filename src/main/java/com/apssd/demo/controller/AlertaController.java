package com.apssd.demo.controller;

import com.apssd.demo.model.Alerta;
import com.apssd.demo.service.AlertaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping("/alertas")
    public List<Alerta> listarAlertas() {
        return alertaService.listarAlertas();
    }

    @GetMapping("/alertas/distancia")
    public double testarDistancia() {
        return alertaService.calcularDistancia(
            -23.5500,
            -46.6340,
            -23.5505,
            -46.6333
        );
    }

    @GetMapping("/alertas/proximos")
    public List<Alerta> buscarAlertasProximos(
        @RequestParam double latitude,
        @RequestParam double longitude) {

        return alertaService.buscarAlertasProximos(
            latitude,
            longitude,
            10
        );
    }
}