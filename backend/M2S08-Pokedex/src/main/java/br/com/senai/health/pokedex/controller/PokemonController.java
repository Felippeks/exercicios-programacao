package br.com.senai.health.pokedex.controller;

import br.com.senai.health.pokedex.dto.PokemonCapturedDTO;
import br.com.senai.health.pokedex.dto.PokemonListDTO;
import br.com.senai.health.pokedex.dto.PokemonSeenDTO;
import br.com.senai.health.pokedex.exception.InternalServerErrorException;
import br.com.senai.health.pokedex.exception.PokemonNotFoundException;
import br.com.senai.health.pokedex.model.Pokemon;
import br.com.senai.health.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
@Validated
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/visto")
    public ResponseEntity<?> cadastrarPokemonVisto(@Valid @RequestBody PokemonSeenDTO pokemonSeenDTO) {
        pokemonService.cadastrarPokemonVisto(pokemonSeenDTO);
        return ResponseEntity.ok("Pokemon visto com sucesso!");
    }

    @PostMapping("/capturado")
    public ResponseEntity<?> cadastrarPokemonCapturado(@Valid @RequestBody PokemonCapturedDTO pokemonCapturedDTO) {
        pokemonService.cadastrarPokemonCapturado(pokemonCapturedDTO);
        return ResponseEntity.ok("Pokemon capturado com sucesso!");
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> atualizarPokemon(@PathVariable String numero, @Valid @RequestBody PokemonCapturedDTO pokemonDTO) {
        Optional<Pokemon> pokemonAtualizado = pokemonService.atualizarPokemon(numero, pokemonDTO);
        return pokemonAtualizado.map(pokemon -> ResponseEntity.ok("Pokemon atualizado com sucesso!"))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<?> excluirPokemon(@PathVariable String numero) {
        try {
            pokemonService.excluirPokemonPeloNumero(numero);
            return ResponseEntity.ok("Pokemon excluído com sucesso!");
        } catch (PokemonNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InternalServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Pokemon> obterPokemonPeloNumero(@PathVariable String numero) {
        try {
            Pokemon pokemon = pokemonService.buscarPokemonPeloNumero(numero);
            return ResponseEntity.ok(pokemon);
        } catch (PokemonNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PokemonListDTO>> listarPokemons() {
        List<PokemonListDTO> pokemons = pokemonService.buscarTodosPokemons();
        return ResponseEntity.ok(pokemons);
    }
}