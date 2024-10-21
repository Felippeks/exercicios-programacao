package com.m3s04.postit.postit.dto;

import java.time.LocalDateTime;

public class ComentarioDTO {
    private Long id;
    private Long sugestaoId;
    private String texto;
    private LocalDateTime dataEnvio;

    public ComentarioDTO() {}

    public ComentarioDTO(Long id, Long sugestaoId, String texto, LocalDateTime dataEnvio) {
        this.id = id;
        this.sugestaoId = sugestaoId;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSugestaoId() {
        return sugestaoId;
    }

    public void setSugestaoId(Long sugestaoId) {
        this.sugestaoId = sugestaoId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}

