import { ChangeDetectorRef, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Move, Pokemon } from '../../../apiModels/models';
import { PokemonTypePipe } from '../../common/pokemon-type.pipe';
import { MovesetService } from '../../core/moveset.service';
import { MoveCategoryPipe } from '../../common/move-category.pipe';

@Component({
  selector: 'app-moveset',
  imports: [PokemonTypePipe, MoveCategoryPipe],
  templateUrl: './moveset.component.html',
  styleUrl: './moveset.component.css'
})
export class MovesetComponent implements OnInit, OnChanges {
  @Input() pokemon?: Pokemon;
  moves?: Move[];

  constructor(
    private cdr: ChangeDetectorRef,
    private movesetService: MovesetService
  ) {}

  displayMoves(): void {
    this.movesetService.searchMoves(this.pokemon?.moves).subscribe(data => {
      this.moves = data.body.moveList;
      console.log(this.pokemon?.moves);
      console.log(data.body.moveList);
      this.cdr.detectChanges();
    });
  }

  ngOnInit(): void {
    this.displayMoves();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pokemon']) {
      this.displayMoves();
    }
  }

}
