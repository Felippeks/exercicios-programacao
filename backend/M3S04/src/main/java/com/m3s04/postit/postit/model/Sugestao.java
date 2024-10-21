package com.m3s04.postit.postit.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataEnvio;

    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void onCreate() {
        this.dataEnvio = LocalDateTime.now();
        this.dataAtualizacao = this.dataEnvio;
    }

    @PreUpdate
    public void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Sugestao() {
    }

    public Sugestao(Long id, String titulo, String descricao, LocalDateTime dataEnvio, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEnvio = dataEnvio;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
