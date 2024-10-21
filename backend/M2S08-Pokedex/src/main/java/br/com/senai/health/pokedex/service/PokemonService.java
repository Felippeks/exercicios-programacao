package br.com.senai.health.pokedex.service;

import br.com.senai.health.pokedex.dto.PokemonCapturedDTO;
import br.com.senai.health.pokedex.dto.PokemonListDTO;
import br.com.senai.health.pokedex.dto.PokemonSeenDTO;
import br.com.senai.health.pokedex.exception.InternalServerErrorException;
import br.com.senai.health.pokedex.exception.PokemonNotFoundException;
import br.com.senai.health.pokedex.model.Pokemon;
import br.com.senai.health.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void cadastrarPokemonVisto(PokemonSeenDTO pokemonSeenDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(pokemonSeenDTO.getNumero());
        Pokemon pokemon = pokemonExistente.orElseGet(() -> {
            Pokemon novoPokemon = new Pokemon();
            novoPokemon.setNumero(pokemonSeenDTO.getNumero());
            return novoPokemon;
        });

        if (!pokemon.getCapturado()) {
            pokemon.setNome(pokemonSeenDTO.getNome());
            pokemon.setImagemUrl(pokemonSeenDTO.getImagemUrl());
            pokemon.setAreaHabita(pokemonSeenDTO.getAreaHabita());
            pokemon.setCapturado(false);
            pokemonRepository.save(pokemon);
        }
    }

    public void cadastrarPokemonCapturado(PokemonCapturedDTO pokemonCapturedDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(pokemonCapturedDTO.getNumero());
        Pokemon pokemon = pokemonExistente.orElseGet(() -> {
            Pokemon novoPokemon = new Pokemon();
            novoPokemon.setNumero(pokemonCapturedDTO.getNumero());
            return novoPokemon;
        });

        pokemon.setNome(pokemonCapturedDTO.getNome());
        pokemon.setDescricao(pokemonCapturedDTO.getDescricao());
        pokemon.setImagemUrl(pokemonCapturedDTO.getImagemUrl());
        pokemon.setTipo(pokemonCapturedDTO.getTipo());
        pokemon.setCategoria(pokemonCapturedDTO.getCategoria());
        pokemon.setAreaHabita(pokemonCapturedDTO.getAreaHabita());
        pokemon.setAltura(pokemonCapturedDTO.getAltura());
        pokemon.setPeso(pokemonCapturedDTO.getPeso());
        pokemon.setCapturado(true);
        pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> atualizarPokemon(String numero, PokemonCapturedDTO pokemonDTO) {
        Optional<Pokemon> pokemonExistente = pokemonRepository.findByNumero(numero);
        if (!pokemonExistente.isPresent()) {
            throw new PokemonNotFoundException("Pokemon não encontrado");
        }
        try {
            pokemonExistente.ifPresent(pokemon -> {
                pokemon.setNome(pokemonDTO.getNome());
                pokemon.setDescricao(pokemonDTO.getDescricao());
                pokemon.setImagemUrl(pokemonDTO.getImagemUrl());
                pokemon.setTipo(pokemonDTO.getTipo());
                pokemon.setCategoria(pokemonDTO.getCategoria());
                pokemon.setAreaHabita(pokemonDTO.getAreaHabita());
                pokemon.setAltura(pokemonDTO.getAltura());
                pokemon.setPeso(pokemonDTO.getPeso());
                pokemon.setCapturado(pokemonDTO.getCapturado());
                pokemonRepository.save(pokemon);
            });
            return pokemonExistente;
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao atualizar o Pokémon.");
        }
    }

    public void excluirPokemonPeloNumero(String numero) throws PokemonNotFoundException, InternalServerErrorException {
        Optional<Pokemon> pokemon = pokemonRepository.findByNumero(numero);
        if (!pokemon.isPresent()) {
            throw new PokemonNotFoundException("Pokemon não encontrado");
        }
        try {
            pokemonRepository.delete(pokemon.get());
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro interno ao excluir o Pokémon.");
        }
    }

    public Pokemon buscarPokemonPeloNumero(String numero) {
        return pokemonRepository.findByNumero(numero)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon não encontrado"));
    }

    public List<PokemonListDTO> buscarTodosPokemons() {
        return pokemonRepository.findAll().stream()
                .map(pokemon -> new PokemonListDTO(pokemon.getNumero(), pokemon.getNome(), pokemon.getCapturado()))
                .collect(Collectors.toList());
    }
}
