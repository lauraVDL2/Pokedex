import { Injectable } from '@angular/core';
import { Pokemon } from '../../apiModels/models';

@Injectable({
  providedIn: 'root'
})
export class EvolutionChartService {

  constructor() {}

  sortEvolutionChart(currentPokemon: Pokemon, evolvedStages: Pokemon[]): Map<number, Pokemon> {
    const map = new Map();
    // Current is last Pokemon of its line
    if(!currentPokemon?.evolutionStageEntry?.next) {
      map.set(evolvedStages.length, currentPokemon);
      // Case of a line of two
      if(evolvedStages.length == 1) {
        map.set(0, evolvedStages[0]);
      }
      else {
        // Order of evolutions
        if(!evolvedStages[0]?.evolutionStageEntry?.previous) {
          map.set(0, evolvedStages[0]);
          map.set(1, evolvedStages[1]);
        }
        else {
          map.set(0, evolvedStages[1]);
          map.set(1, evolvedStages[0]);
        }
      }
    }
    // Current is first Pokemon of its line
    else if(!currentPokemon?.evolutionStageEntry?.previous) {
      map.set(0, currentPokemon);
      // Case of a line of two
      if(evolvedStages.length == 1) {
        map.set(1, evolvedStages[0]);
      }
      else {
        // Order of evolutions
        if (evolvedStages[0]?.evolutionStageEntry?.next?.length == 1) {
          if(!evolvedStages[0]?.evolutionStageEntry?.next?.at(0)) {
            map.set(2, evolvedStages[0]);
            map.set(1, evolvedStages[1]);
          }
          else {
            map.set(2, evolvedStages[1]);
            map.set(1, evolvedStages[0]);
          }
        }
        // Eevee
        else {
          for(let i = 0; i < evolvedStages.length; i++) {
            map.set(i + 1, evolvedStages[i]);
          }
        }
      }
    }
    // Middle evolution stage (always in line of three in this case)
    else {
      map.set(1, currentPokemon);
      if (!evolvedStages[0]?.evolutionStageEntry?.next?.at(0)) {
        map.set(2, evolvedStages[0]);
        map.set(0, evolvedStages[1]);
      }
      else {
        map.set(2, evolvedStages[1]);
        map.set(0, evolvedStages[0]);
      }
      // In case of multiple evolutions possibles, we don't erase what has been done before
      if (evolvedStages[0]?.evolutionStageEntry?.next?.length && 
      evolvedStages[0]?.evolutionStageEntry?.next?.length > 1) {
        for(let i = 2; i < evolvedStages.length; i++) {
          map.set(i + 1, evolvedStages[i]);
        }
      }
    }
    return new Map([...map.entries()].sort());
  }

}
