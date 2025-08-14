import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FullPokemonComponent } from './full-pokemon.component';

describe('FullPokemonComponent', () => {
  let component: FullPokemonComponent;
  let fixture: ComponentFixture<FullPokemonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FullPokemonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FullPokemonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
