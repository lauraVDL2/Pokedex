import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonStatisticsComponent } from './pokemon-statistics.component';

describe('PokemonStatisticsComponent', () => {
  let component: PokemonStatisticsComponent;
  let fixture: ComponentFixture<PokemonStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokemonStatisticsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokemonStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
