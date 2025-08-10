import { Injectable } from '@angular/core';
import { Pokemon } from '../../apiModels/models';

@Injectable({
  providedIn: 'root'
})
export class EvolutionChartService {

  constructor() {}

  sortEvolutionChart(currentPokemon: Pokemon, evolvedStages: Pokemon[]): Map<number, Pokemon> {
    const map = new Map();
    if(!currentPokemon?.evolutionStageEntry?.next) {
      map.set(evolvedStages.length, currentPokemon);
      if(evolvedStages.length == 1) {
        map.set(0, evolvedStages[0]);
      }
      else {
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
    else if(!currentPokemon?.evolutionStageEntry?.previous) {
      map.set(0, currentPokemon);
      if(evolvedStages.length == 1) {
        map.set(1, evolvedStages[0]);
      }
      else {
        if(!evolvedStages[0]?.evolutionStageEntry?.next) {
          map.set(2, evolvedStages[0]);
          map.set(1, evolvedStages[1]);
        }
        else {
          map.set(2, evolvedStages[1]);
          map.set(1, evolvedStages[0]);
        }
      }
    }
    // Middle evolution stage (always in line of three in this case)
    else {
      map.set(1, currentPokemon);
      if (!evolvedStages[0]?.evolutionStageEntry?.next) {
        map.set(2, evolvedStages[0]);
        map.set(0, evolvedStages[1]);
      }
      else {
        map.set(2, evolvedStages[1]);
        map.set(0, evolvedStages[0]);
      }
    }
    return new Map([...map.entries()].sort());
  }

}
