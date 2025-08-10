import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FullPokemonService } from '../../core/full-pokemon.service';
import { Move, Pokemon } from '../../../apiModels/models';
import { StrictHttpResponse } from '../../../apiModels/strict-http-response';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';

@Component({
  selector: 'app-full-pokemon',
  imports: [],
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
  ) {
    this.route.params.subscribe(params => {
      this.entryNumber = params['entryNumber'];
    });
  }

  ngOnInit(): void {
    this.fullPokemonService.getFullPokemon(this.entryNumber).subscribe({
      next: (data) => {
        this.pokemon = data.pokemon;
        this.evolutions = data?.evolutions?.slice();
        this.moves = data?.moves?.slice();
        document.body.style.backgroundColor = this.pokemonTypePipe.transform(this.pokemon?.types?.at(0))
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
