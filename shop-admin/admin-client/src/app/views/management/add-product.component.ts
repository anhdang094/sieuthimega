import {Component, ViewChild, ViewEncapsulation} from '@angular/core';
import {IOption} from 'ng-select';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {environment} from "../../../environments/environment";
import {ManagementService} from "./management.service";

@Component({
  templateUrl: 'add-product.component.html',
  styleUrls: [
    '../../../scss/vendors/bs-datepicker/bs-datepicker.scss',
    '../../../scss/vendors/ng-select/ng-select.scss'
  ],
  encapsulation: ViewEncapsulation.None
})
export class AddProductComponent {

  env = environment;

  constructor(private managementService: ManagementService) {

  }

  public Editor = ClassicEditor;
  // ng2-select
  public menuTypes: Array<IOption> = [
    {label: 'Thiết bị điện tử', value: 'thietbidientu'},
    {label: 'Thời trang nữ', value: 'thoitrangnu'},
    {label: 'Thời trang nam', value: 'thoitrangnam'},
    {label: 'Đồ dùng nhà bếp', value: 'nhabep'},
    {label: 'Giày, túi xách, vali', value: 'giaytuixach'},
    {label: 'Camera', value: 'camera'},
    {label: 'Linh kiện máy tính', value: 'linhkienmaytinh'},
    {label: 'Nội thất gia dụng', value: 'noithatgiadung'},
    {label: 'Mẹ và bé', value: 'mevabe'},
    {label: 'Chợ đồ cũ', value: 'chodocu'}
  ];

  // Allows us to get a reference to the FilePond instance
  @ViewChild('myPond') myPond: any;

//model
  public name = '';
  public title = '';
  public description = '';
  public brand = '';
  public menuType = '';
  public baseCost = '';
  public cost = '';
  public merchantId = '';
  public companyPhone = '';
  public maintanceDay = '';
  public maintanceAddress = '';
  public specialContent = '';
  public content = '';
  public information = '';
  public suggest = '';
  public imageIds = '';
  public code = '';

  registerProduct() {
    this.managementService.registerProduct({
      name: this.name,
      title: this.title,
      description: this.description,
      brand: this.brand,
      menuType: this.menuType,
      baseCost: this.baseCost,
      cost: this.cost,
      merchantId: this.merchantId,
      companyPhone: this.companyPhone,
      maintanceDay: this.maintanceDay,
      maintanceAddress: this.maintanceAddress,
      specialContent: this.specialContent,
      content: this.content,
      information: this.information,
      suggest: this.suggest,
      imageIds: this.imageIds,
      code: this.code,
    })
    ;
  }

}
