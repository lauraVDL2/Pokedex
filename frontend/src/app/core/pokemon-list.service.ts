import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PokemonListResponse } from '../../apiModels/models';
import { StrictHttpResponse } from '../../apiModels/strict-http-response';
import { postPokemonSearch } from '../../apiModels/fn/pokemon/post-pokemon-search';
import { getAllPokemon } from '../../apiModels/fn/pokemon/get-all-pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonListService {
  private rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getPokemonList(offset: number, limit: number): Observable<StrictHttpResponse<PokemonListResponse>> {
    return getAllPokemon(this.http, this.rootUrl, { offset: offset, limit: limit });
  }

  searchPokemon(name: string): Observable<StrictHttpResponse<PokemonListResponse>> {
    return postPokemonSearch(this.http, this.rootUrl, { body: { name: name }} );
  }

  getPokemonCount() {
    return this.http.get<number>(`${this.rootUrl}/api/pokemon/count`);
  }
  
}
