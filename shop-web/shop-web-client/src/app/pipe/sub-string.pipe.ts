import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'subString'})
export class SubStringPipe implements PipeTransform {

  transform(value: string, char: string, isFront: boolean): string {
    let index = value.indexOf(char);
    return isFront ? value.substr(0, index) : value.substr(index);
  }

}
