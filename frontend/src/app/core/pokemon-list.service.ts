import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from '../../apiModels/models';

@Injectable({
  providedIn: 'root'
})
export class PokemonListService {
  private apiUrl = 'http://localhost:8080/v1/pokedex/pokemon?offset=1&limit=50';

  constructor(private http: HttpClient) {}

  getAllPokemon(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.apiUrl);
  }
  
}
