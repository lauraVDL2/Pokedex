import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Pokemon } from '../../../apiModels/models';
import { PokemonListService } from '../../core/pokemon-list.service';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';
import { Router } from '@angular/router';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { debounceTime, switchMap } from 'rxjs';

@Component({
  selector: 'app-pokemon-list',
  imports: [PokemonTypePipe, ReactiveFormsModule],
  standalone: true,
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css',
  providers: [],
  encapsulation: ViewEncapsulation.None
})
export class PokemonListComponent implements OnInit {
  pokemonList: Pokemon[] | undefined = [];
  searchControl: FormControl = new FormControl('');

  constructor(
    private cdr: ChangeDetectorRef,
    private pokemonListService: PokemonListService,
    private router: Router) {}

  ngOnInit(): void {
    this.getPokemonList();
    this.searchControl.valueChanges
      .pipe(
        debounceTime(1000), // wait 1 second after last keystroke
        switchMap((value) => {
          if(value === "") {
            return this.pokemonListService.getPokemonList();
          }
          return this.pokemonListService.searchPokemon(value);
        })
      )
      .subscribe((response) => {
        this.pokemonList = response.body.pokemonList?.slice();
        this.cdr.detectChanges();
      });
  }
  
  goToPokemon(entryNumber: number | undefined): void {
    this.router.navigate(['/pokemon', entryNumber]);
  }

  getPokemonList(): void {
    this.pokemonListService.getPokemonList().subscribe({
      next: (data) => {
          this.pokemonList = data.body.pokemonList;
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

}
