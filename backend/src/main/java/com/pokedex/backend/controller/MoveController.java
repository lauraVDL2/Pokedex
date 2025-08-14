package com.pokedex.backend.controller;

import com.pokedex.backend.service.MoveService;
import io.swagger.api.MoveApi;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MoveController implements MoveApi {
    @Autowired
    MoveService moveService;

    @Override
    public ResponseEntity<MoveResponse> postMoveCreate(PokedexMoveBody body) {
        Move move = moveService.createMove(body.getMove());
        MoveResponse response = new MoveResponse().move(move);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MoveListResponse> postMoveSearch(MoveSearchBody body) {
        List<Move> moves = moveService.searchMoves(body.getNames());
        MoveListResponse response = new MoveListResponse().moveList(moves);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }
}
