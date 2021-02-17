import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'costFormat'})
export class CostFormatPipe implements PipeTransform {

  transform(value: number): string {
    if (value || value == 0) {
      return value.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1.") + " đ";
    }
    return "";
  }

}
