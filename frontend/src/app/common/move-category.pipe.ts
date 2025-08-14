import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moveCategory'
})
export class MoveCategoryPipe implements PipeTransform {

  transform(value: string | undefined): string {
    switch(value) {
      case 'PHYSICAL':
        return 'Physical';
      case 'NON_DAMAGING':
        return 'Non damaging';
      case 'SPECIAL':
        return 'Special';
      default:
        return 'Unknown'
    }
  }

}
