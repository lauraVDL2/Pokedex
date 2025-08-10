package com.pokedex.backend.service;

import com.mongodb.client.result.DeleteResult;
import com.pokedex.backend.dao.PokemonDao;
import io.swagger.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Pokemon nextPokemon = null;
        List<Pokemon> evolutions = new ArrayList<>();
        short i = 0;
        // One way
        while(currentPokemon.getEvolutionStageEntry() != null && i < 3) {
            List<Integer> nextEvolvedStates = currentPokemon.getEvolutionStageEntry().getNext();
            if (CollectionUtils.isEmpty(nextEvolvedStates)) break;
            if (nextEvolvedStates.size() > 1) {
                for(Integer next : nextEvolvedStates) {
                    nextPokemon = pokemonDao.getPokemon(next);
                    evolutions.add(nextPokemon);
                }
                currentPokemon = nextPokemon;
            }
            else {
                nextPokemon = pokemonDao.getPokemon(nextEvolvedStates.getFirst());
                currentPokemon = nextPokemon;
                evolutions.add(currentPokemon);
            }
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
