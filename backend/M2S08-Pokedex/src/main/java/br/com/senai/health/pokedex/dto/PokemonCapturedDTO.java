package br.com.senai.health.pokedex.dto;

import br.com.senai.health.pokedex.model.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonCapturedDTO {
    @NotBlank(message = "O número do Pokémon é obrigatório")
    private String numero;
    @NotBlank(message = "O nome do Pokémon é obrigatório")
    private String nome;
    @NotBlank(message = "A descrição do Pokémon é obrigatória")
    private String descricao;
    @NotBlank(message = "A URL da imagem do Pokémon é obrigatória")
    private String imagemUrl;
    @NotNull(message = "O tipo do Pokémon é obrigatório")
    private Type tipo;
    @NotBlank(message = "A categoria do Pokémon é obrigatória")
    private String categoria;
    @NotBlank(message = "A área de habitação do Pokémon é obrigatória")
    private String areaHabita;
    @NotBlank(message = "A altura do Pokémon é obrigatória")
    private Double altura;
    @NotBlank(message = "O peso do Pokémon é obrigatório")
    private Double peso;
    @NotNull(message = "O status de captura do Pokémon é obrigatório")
    private Boolean capturado;

    // Constructors
    public PokemonCapturedDTO() {
    }

    public PokemonCapturedDTO(String numero, String nome, String descricao, String imagemUrl, Type tipo, String categoria, String areaHabita, Double altura, Double peso, Boolean capturado) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.tipo = tipo;
        this.categoria = categoria;
        this.areaHabita = areaHabita;
        this.altura = altura;
        this.peso = peso;
        this.capturado = capturado;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaHabita() {
        return areaHabita;
    }

    public void setAreaHabita(String areaHabita) {
        this.areaHabita = areaHabita;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getCapturado() {
        return capturado;
    }

    public void setCapturado(Boolean capturado) {
        this.capturado = capturado;
    }
}