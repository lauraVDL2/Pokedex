import { ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Pokemon } from '../../../apiModels/models';
import { EvolutionChartService } from '../../core/evolution-chart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-evolution-chart',
  imports: [],
  templateUrl: './evolution-chart.component.html',
  styleUrl: './evolution-chart.component.css'
})
export class EvolutionChartComponent implements OnInit {
  @Input() currentPokemon!: Pokemon;
  @Input() evolutions!: Pokemon[];
  evolutionChart!: Pokemon[];
  gridTemplateColumns: string = `1fr 1fr 1fr`;
  @Output() pageChange = new EventEmitter<number>();

  constructor(
    private evolutionChartService: EvolutionChartService,
    private cdr: ChangeDetectorRef
  ) {}

  notifyParent(entryNumber: number | undefined) {
    this.pageChange.emit(entryNumber);
  }

  ngOnInit(): void {
    const map = this.evolutionChartService.sortEvolutionChart(this.currentPokemon, this.evolutions);
    this.evolutionChart = [];
    map.forEach((value, key, mymap) => {
      this.evolutionChart.push(value);
    });
    this.gridTemplateColumns = `repeat(${this.evolutionChart.length}, 150px)`;
    this.cdr.detectChanges();
    console.log(this.evolutionChart);
  }

}
