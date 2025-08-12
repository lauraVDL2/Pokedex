import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon, PokemonListResponse } from '../../apiModels/models';
import { StrictHttpResponse } from '../../apiModels/strict-http-response';
import { postPokemonSearch } from '../../apiModels/fn/pokemon/post-pokemon-search';
import { getAllPokemon } from '../../apiModels/fn/pokemon/get-all-pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonListService {
  private apiUrl = 'http://localhost:8080/v1/pokedex/pokemon?offset=1&limit=50';

  constructor(private http: HttpClient) {}

  getPokemonList(): Observable<StrictHttpResponse<PokemonListResponse>> {
    return getAllPokemon(this.http, 'http://localhost:8080');
  }

  searchPokemon(name: string): Observable<StrictHttpResponse<PokemonListResponse>> {
    return postPokemonSearch(this.http, 'http://localhost:8080', { body: { name: name }} );
  }
  
}
