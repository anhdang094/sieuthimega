import { Component } from '@angular/core';
import {IOption} from "ng-select";

@Component({
  templateUrl: 'product.component.html'
})
export class ProductComponent {

  constructor() { }

  public products: Array<IOption> = [
    {label: 'Thiết bị điện tử', value: '1'},
    {label: 'Thời trang nữ', value: '2'},
    {label: 'Thời trang nam', value: '3'},
    {label: 'Đồ dùng nhá bếp', value: '4'},
    {label: 'Giày, túi xách, vali', value: '5'},
    {label: 'Camera', value: '6'},
    {label: 'Linh kiện máy tính', value: '7'},
    {label: 'Phòng ngủ', value: '8'},
    {label: 'Chợ đồ cũ', value: '9'},
    {label: 'Chợ đồ cũ', value: '9'},
    {label: 'Thiết bị điện tử', value: '1'},
    {label: 'Thời trang nữ', value: '2'},
    {label: 'Thời trang nam', value: '3'},
    {label: 'Đồ dùng nhá bếp', value: '4'},
    {label: 'Giày, túi xách, vali', value: '5'}
  ];

}
