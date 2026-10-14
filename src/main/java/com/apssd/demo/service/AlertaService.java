package com.apssd.demo.service;

import com.apssd.demo.model.Alerta;
import com.apssd.demo.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;

    public AlertaService(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }

    public double calcularDistancia(
        double latitudeUsuario,
        double longitudeUsuario,
        double latitudeAlerta,
        double longitudeAlerta) {

    double raioTerra = 6371.0;

    double diferencaLatitude = Math.toRadians(latitudeAlerta - latitudeUsuario);
    double diferencaLongitude = Math.toRadians(longitudeAlerta - longitudeUsuario);

    double a = Math.sin(diferencaLatitude / 2) * Math.sin(diferencaLatitude / 2)
            + Math.cos(Math.toRadians(latitudeUsuario))
            * Math.cos(Math.toRadians(latitudeAlerta))
            * Math.sin(diferencaLongitude / 2) * Math.sin(diferencaLongitude / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return raioTerra * c;
    }

    public List<Alerta> buscarAlertasProximos(
        double latitudeUsuario,
        double longitudeUsuario,
        double distanciaMaxima) {

        List<Alerta> alertas = alertaRepository.findAll();

        return alertas.stream()
                .filter(alerta -> alerta.getLatitude() != null
                        && alerta.getLongitude() != null)
                .filter(alerta -> calcularDistancia(
                        latitudeUsuario,
                        longitudeUsuario,
                        alerta.getLatitude(),
                        alerta.getLongitude()
                ) <= distanciaMaxima)
                .toList();
    }
}