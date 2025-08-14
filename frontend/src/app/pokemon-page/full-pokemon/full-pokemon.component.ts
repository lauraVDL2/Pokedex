import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FullPokemonService } from '../../core/full-pokemon.service';
import { Move, Pokemon } from '../../../apiModels/models';
import { StrictHttpResponse } from '../../../apiModels/strict-http-response';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';
import { EvolutionChartComponent } from '../evolution-chart/evolution-chart.component';
import { PokemonStatisticsComponent } from '../pokemon-statistics/pokemon-statistics.component';
import { MovesetComponent } from '../moveset/moveset.component';

@Component({
  selector: 'app-full-pokemon',
  imports: [EvolutionChartComponent, PokemonStatisticsComponent, MovesetComponent],
  standalone: true,
  templateUrl: './full-pokemon.component.html',
  styleUrl: './full-pokemon.component.css',
  providers: [PokemonTypePipe],
  encapsulation: ViewEncapsulation.None
})
export class FullPokemonComponent implements OnInit {
  entryNumber!: number;
  pokemon?: Pokemon;
  evolutions?: Pokemon[];
  moves?: Move[];

  constructor(
    private route: ActivatedRoute,
    private fullPokemonService: FullPokemonService,
    private cdr: ChangeDetectorRef,
    private pokemonTypePipe: PokemonTypePipe,
    private router: Router
  ) {
    this.route.params.subscribe(params => {
      this.entryNumber = params['entryNumber'];
    });
  }

  goHome(): void {
    this.router.navigate(['/']);
  }

  onPageChange(entryNumber: number): void {
    this.entryNumber = entryNumber;
    this.router.navigate(['/pokemon', entryNumber]);
    this.getFullPokemon(entryNumber);
  }

  ngOnInit(): void {
    this.getFullPokemon(this.entryNumber);
  }

  getFullPokemon(entryNumber: number): void {
    this.fullPokemonService.getFullPokemon(entryNumber).subscribe({
      next: (data) => {
        this.pokemon = data.pokemon;
        this.evolutions = data?.evolutions?.slice();
        this.moves = data?.moves?.slice();
        const firstColor = this.pokemonTypePipe.transform(this.pokemon?.types?.at(0));
        if (this.pokemon?.types?.at(1)) {
          const secondColor = this.pokemonTypePipe.transform(this.pokemon?.types?.at(1));
          document.body.style.background = `linear-gradient(to right, ${firstColor}, ${secondColor})`;
        }
        else {
          document.body.style.background = firstColor;
        }
        this.cdr.detectChanges();
      },
      error: (err: any) => {
          console.error(err);
      },
      complete: () => {
          console.log('Observable completed.');
      }
    });
  }
}
