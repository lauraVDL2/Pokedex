import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Pokemon } from '../../../apiModels/models';
import { PokemonListService } from '../../core/pokemon-list.service';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';

@Component({
  selector: 'app-pokemon-list',
  imports: [PokemonTypePipe],
  standalone: true,
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css',
  providers: [],
  encapsulation: ViewEncapsulation.None
})
export class PokemonListComponent implements OnInit {
  pokemonList: Pokemon[] = [];

  constructor(private cdr: ChangeDetectorRef, private pokemonListService: PokemonListService) {}

  ngOnInit(): void {
    this.pokemonListService.getAllPokemon().subscribe({
      next: (data: Pokemon[]) => {
          this.pokemonList = data.slice();
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
