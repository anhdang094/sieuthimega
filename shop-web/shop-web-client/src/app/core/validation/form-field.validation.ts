import {AbstractControl, ValidatorFn} from "@angular/forms";
import {Promotion} from "../../model/promotion.model";


export function formFieldValidation(promotions: Promotion[]): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const invalid = promotions.map(item => item.code).includes(control.value);
    return !invalid && control.value.length > 0 ? {'invalid': {value: control.value}} : null;
  };
}
