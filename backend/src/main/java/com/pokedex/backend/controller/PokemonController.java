package com.pokedex.backend.controller;

import com.pokedex.backend.exceptionhandler.exceptions.MandatoryDataException;
import com.pokedex.backend.service.MoveService;
import com.pokedex.backend.service.PokemonService;
import io.swagger.api.PokemonApi;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController implements PokemonApi {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    MoveService moveService;

    @Override
    public ResponseEntity<InlineResponse204> deletePokemon(Integer entryNumber) {
        String message = pokemonService.deletePokemon(entryNumber);
        InlineResponse204 inlineResponse204 = new InlineResponse204().message(message);
        return new ResponseEntity<>(inlineResponse204, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<PokemonListResponse> getAllPokemon(Integer offset, Integer limit) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon(offset, limit);
        PokemonListResponse response = new PokemonListResponse().pokemonList(pokemonList);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InlineResponse200> getPokemon(Integer entryNumber) {
        Pokemon mainPokemon = pokemonService.getPokemon(entryNumber);
        List<Pokemon> evolutions = pokemonService.getEvolutions(mainPokemon);
        List<Move> moves = moveService.searchMoves(mainPokemon.getMoves());
        InlineResponse200 inlineResponse200 = new InlineResponse200();
        inlineResponse200.setPokemon(mainPokemon);
        inlineResponse200.setEvolutions(evolutions);
        inlineResponse200.setMoves(moves);
        return new ResponseEntity<>(inlineResponse200, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pokemon> postPokemonCreate(Pokemon body) {
        Pokemon pokemon = pokemonService.createPokemon(body);
        return new ResponseEntity<>(pokemon, new HttpHeaders(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PokemonListResponse> postPokemonSearch(PokemonSearchBody body) {
        if (body == null) {
            throw new MandatoryDataException("Body is mandatory");
        }
        List<Pokemon> pokemonList = pokemonService.searchPokemon(body.getName());
        PokemonListResponse response = new PokemonListResponse().pokemonList(pokemonList);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    // No need of swagger here
    @GetMapping("/api/pokemon/count")
    public Long getPokemonCount() {
        return pokemonService.getPokemonCount();
    }
}
