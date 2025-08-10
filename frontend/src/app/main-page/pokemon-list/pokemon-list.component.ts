import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Pokemon } from '../../../apiModels/models';
import { PokemonListService } from '../../core/pokemon-list.service';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';
import { Router } from '@angular/router';

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

  constructor(
    private cdr: ChangeDetectorRef,
    private pokemonListService: PokemonListService,
    private router: Router) {}

  ngOnInit(): void {
    this.pokemonListService.getAllPokemon().subscribe({
      next: (data: Pokemon[]) => {
          this.pokemonList = data.slice();
          document.body.style.background = "#4B4B4B";
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
  
  goToPokemon(entryNumber: number | undefined): void {
    this.router.navigate(['/pokemon', entryNumber]);
  }
}
