import { ChangeDetectorRef, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Pokemon } from '../../../apiModels/models';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';

@Component({
  selector: 'app-pokemon-statistics',
  imports: [ ],
  templateUrl: './pokemon-statistics.component.html',
  styleUrl: './pokemon-statistics.component.css',
  providers: [PokemonTypePipe]
})
export class PokemonStatisticsComponent implements OnInit, OnChanges {
  @Input() pokemon!: Pokemon;
  backgroundColor: string = 'white';

  constructor(
    private pokemonTypePipe: PokemonTypePipe,
    private cdr: ChangeDetectorRef 
  ) {};

  getWidth(value: number | undefined): string {
    if (!value) value = 0;
    return (value / 255 * 100) + '%';
  }

  setColors() {
    const firstColor = this.pokemonTypePipe.transform(this.pokemon?.types?.at(0));
    if (this.pokemon?.types?.at(1)) {
      const secondColor = this.pokemonTypePipe.transform(this.pokemon?.types?.at(1));
      this.backgroundColor = `linear-gradient(to right, ${firstColor}, ${secondColor})`;
    }
    else {
      this.backgroundColor = firstColor;
    }
    this.cdr.detectChanges();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pokemon']) {
      this.setColors();
    }
  }

  ngOnInit(): void {
    this.setColors();
  }
}
