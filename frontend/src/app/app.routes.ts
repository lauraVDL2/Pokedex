import { Routes } from '@angular/router';
import { FullPokemonComponent } from './pokemon-page/full-pokemon/full-pokemon.component';
import { PokemonListComponent } from './main-page/pokemon-list/pokemon-list.component';

export const routes: Routes = [
    { path: 'pokemon/:entryNumber', component: FullPokemonComponent },
    { path: '', component: PokemonListComponent }
];
