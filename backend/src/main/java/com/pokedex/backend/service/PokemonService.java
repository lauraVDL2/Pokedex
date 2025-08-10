package com.pokedex.backend.service;

import com.mongodb.client.result.DeleteResult;
import com.pokedex.backend.dao.PokemonDao;
import io.swagger.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonDao pokemonDao;

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonDao.createEntity(pokemon, "Pokemon");
    }

    public String deletePokemon(Integer entryNumber) {
        DeleteResult deletion = pokemonDao.deletePokemon(entryNumber);
        if (deletion.getDeletedCount() > 0) {
            return "Pokemon n°" + entryNumber + " deleted successfully !";
        }
        else {
            return "Error deleting Pokemon n°" + entryNumber + ", are you sure it exists ?";
        }
    }

    public List<Pokemon> getAllPokemon(Integer offset, Integer limit) {
        // By default, if not specified, we are on the first page with a limit of 50 elements
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 50;
        }
        return pokemonDao.getAllEntityWithPagination(offset, limit, "Pokemon", Pokemon.class);
    }

    public Pokemon getPokemon(Integer entryNumber) {
        return pokemonDao.getPokemon(entryNumber);
    }

    public List<Pokemon> getEvolutions(Pokemon pokemon) {
        Pokemon currentPokemon = pokemon;
        List<Pokemon> evolutions = new ArrayList<>();
        short i = 0;
        // One way
        while(currentPokemon.getEvolutionStageEntry() != null && i < 3) {
            if (currentPokemon.getEvolutionStageEntry().getNext() == null) break;
            Pokemon nextPokemon = pokemonDao.getPokemon(currentPokemon.getEvolutionStageEntry().getNext());
            currentPokemon = nextPokemon;
            evolutions.add(currentPokemon);
            i++;
        }
        currentPokemon = pokemon;
        i = 0;
        //The other way
        while(currentPokemon.getEvolutionStageEntry() != null && i < 3) {
            if (currentPokemon.getEvolutionStageEntry().getPrevious() == null) break;
            Pokemon previousPokemon = pokemonDao.getPokemon(currentPokemon.getEvolutionStageEntry().getPrevious());
            currentPokemon = previousPokemon;
            evolutions.add(currentPokemon);
            i++;
        }
        return evolutions;
    }

}
