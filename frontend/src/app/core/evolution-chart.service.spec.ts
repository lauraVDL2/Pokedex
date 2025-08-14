import { TestBed } from '@angular/core/testing';

import { EvolutionChartService } from './evolution-chart.service';

describe('EvolutionChartService', () => {
  let service: EvolutionChartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EvolutionChartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
