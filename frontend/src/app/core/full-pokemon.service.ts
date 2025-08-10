import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StrictHttpResponse } from '../../apiModels/strict-http-response';
import { Move, Pokemon } from '../../apiModels/models';

@Injectable({
  providedIn: 'root'
})
export class FullPokemonService {

  constructor(private http: HttpClient) {}

  getFullPokemon(entryNumber: number): Observable<{
  'pokemon'?: Pokemon;
  'moves'?: Array<Move>;
  'evolutions'?: Array<Pokemon>;
}> {
    console.log(`http://localhost:8080/v1/pokedex/pokemon/${entryNumber}`);
    return this.http.get<{
  'pokemon'?: Pokemon;
  'moves'?: Array<Move>;
  'evolutions'?: Array<Pokemon>;
}>(`http://localhost:8080/v1/pokedex/pokemon/${entryNumber}`);
  }
  
}
