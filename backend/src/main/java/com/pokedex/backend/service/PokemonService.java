package com.pokedex.backend.service;

import com.mongodb.client.result.DeleteResult;
import com.pokedex.backend.dao.PokemonDao;
import io.swagger.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
