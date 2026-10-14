package com.apssd.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String titulo;
    private String descricao;
    private String nivel;
    private Double latitude;
    private Double longitude;


    public Alerta() {
    }

    public Alerta(String tipo, String titulo, String descricao, String nivel,
              Double latitude, Double longitude) {
    this.tipo = tipo;
    this.titulo = titulo;
    this.descricao = descricao;
    this.nivel = nivel;
    this.latitude = latitude;
    this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}