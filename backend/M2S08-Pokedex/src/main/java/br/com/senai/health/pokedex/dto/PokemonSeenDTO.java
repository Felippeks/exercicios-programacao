package br.com.senai.health.pokedex.dto;

import br.com.senai.health.pokedex.model.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonSeenDTO {
    @NotBlank(message = "O número do Pokémon é obrigatório")
    private String numero;
    @NotBlank(message = "O nome do Pokémon é obrigatório")
    private String nome;
    @NotBlank(message = "A URL da imagem do Pokémon é obrigatória")
    private String imagemUrl;
    @NotBlank(message = "A área de habitação do Pokémon é obrigatória")
    private String areaHabita;
    @NotNull(message = "O tipo do Pokémon é obrigatório")
    private Type tipo;

    // Constructors
    public PokemonSeenDTO() {
    }

    public PokemonSeenDTO(String numero, String nome, String imagemUrl, String areaHabita, Type tipo) {
        this.numero = numero;
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.areaHabita = areaHabita;
        this.tipo = tipo;
    }

    // Getters and Setters
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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getAreaHabita() {
        return areaHabita;
    }

    public void setAreaHabita(String areaHabita) {
        this.areaHabita = areaHabita;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}