package br.com.senai.health.pokedex.dto;

public class PokemonListDTO {
    private String numero;
    private String nome;
    private Boolean capturado;

    // Constructors, Getters, and Setters
    public PokemonListDTO() {
    }

    public PokemonListDTO(String numero, String nome, Boolean capturado) {
        this.numero = numero;
        this.nome = nome;
        this.capturado = capturado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getCapturado() {
        return capturado;
    }

    public void setCapturado(Boolean capturado) {
        this.capturado = capturado;
    }
}