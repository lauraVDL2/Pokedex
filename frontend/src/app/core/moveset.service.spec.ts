import { TestBed } from '@angular/core/testing';

import { MovesetService } from './moveset.service';

describe('MovesetService', () => {
  let service: MovesetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovesetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
