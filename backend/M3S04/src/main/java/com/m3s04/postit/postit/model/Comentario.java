package com.m3s04.postit.postit.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sugestao_id")
    private Sugestao sugestao;

    private String texto;

    private LocalDateTime dataEnvio;

    @PrePersist
    public void onCreate() {
        this.dataEnvio = LocalDateTime.now();
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
