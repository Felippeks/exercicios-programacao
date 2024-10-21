package br.com.senai.health.pokedex.repository;

import br.com.senai.health.pokedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByNumero(String numero);
}