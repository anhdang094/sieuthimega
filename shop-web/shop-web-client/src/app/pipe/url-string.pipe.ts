import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'urlString'})
export class UrlStringPipe implements PipeTransform {

  transform(value: string, args?: any): string {
    return value.replace(/\s/g, "-");
  }

}
