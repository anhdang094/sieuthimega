// Angular
import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
// Theme Routing
import {ManagementRoutingModule} from './management-routing.module';
import {ProductComponent} from "./product.component";
import {AddProductComponent} from "./add-product.component";
import {FormsModule} from "@angular/forms";
import {TextMaskModule} from "angular2-text-mask";
import {BsDatepickerModule, ModalModule, TimepickerModule} from "ngx-bootstrap";
import {SelectModule} from "ng-select";
import {CKEditorModule} from "@ckeditor/ckeditor5-angular";
import {ModalComponent} from "./modal.component";
import {FilePondModule} from "angular-filepond/dist/angular-filepond.module";
import {ManagementService} from "./management.service";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  imports: [
    CommonModule,
    ManagementRoutingModule,
    CommonModule,
    FormsModule,
    TextMaskModule,
    TimepickerModule.forRoot(),
    BsDatepickerModule.forRoot(),
    SelectModule,
    CKEditorModule,
    FilePondModule,
    HttpClientModule,
    ModalModule.forRoot()
  ],
  providers: [
    //service
    ManagementService
  ],
  declarations: [
    ProductComponent,
    AddProductComponent,
    ModalComponent
  ]
})
export class ManagementModule {
}
