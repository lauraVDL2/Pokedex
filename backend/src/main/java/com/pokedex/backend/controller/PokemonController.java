package com.pokedex.backend.controller;

import com.pokedex.backend.service.PokemonService;
import io.swagger.api.PokemonApi;
import io.swagger.model.InlineResponse204;
import io.swagger.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController implements PokemonApi {

    @Autowired
    PokemonService pokemonService;

    @Override
    public ResponseEntity<InlineResponse204> deletePokemon(Integer entryNumber) {
        String message = pokemonService.deletePokemon(entryNumber);
        InlineResponse204 inlineResponse204 = new InlineResponse204().message(message);
        return new ResponseEntity<>(inlineResponse204, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Pokemon>> getAllPokemon(Integer offset, Integer limit) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon(offset, limit);
        return new ResponseEntity<>(pokemonList, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pokemon> postPokemonCreate(Pokemon body) {
        Pokemon pokemon = pokemonService.createPokemon(body);
        return new ResponseEntity<>(pokemon, new HttpHeaders(), HttpStatus.CREATED);
    }
}
