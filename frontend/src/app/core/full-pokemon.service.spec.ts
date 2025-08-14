import { TestBed } from '@angular/core/testing';

import { FullPokemonService } from './full-pokemon.service';

describe('FullPokemonService', () => {
  let service: FullPokemonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FullPokemonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
