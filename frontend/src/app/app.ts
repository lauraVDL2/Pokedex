import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PokemonListComponent } from "./main-page/pokemon-list/pokemon-list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PokemonListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
