import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {HeaderComponent} from './component/header.component';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserModule} from '@angular/platform-browser';
import {FooterComponent} from './component/footer.component';
import {AppRoutingModule} from '../routing.module';
import {HeaderService} from '../service/header.service';
import {HttpService} from '../service/http.service';
import {HttpClientModule} from '@angular/common/http';
import {ProductComponent} from "./component/product.component";
import {MenuComponent} from "./component/menu.component";
import {HotMenuComponent} from "./component/hot-menu.component";
import {ShopCookieService} from '../service/cookie.service';
import {CookieService} from '../../../node_modules/ngx-cookie-service';
import {SearchMenuComponent} from "./component/search-menu.component";
import {TopComponent} from "./component/top.component";
import {UserSuggestComponent} from "./component/user-suggest.component";
import {DealSuggestComponent} from "./component/deal-suggest.component";
import {CostFormatPipe} from "../pipe/cost.pipe";
import {SubStringPipe} from "../pipe/sub-string.pipe";
import {ProductGroupMenuComponent} from "./component/product-group-menu.component";
import {UrlStringPipe} from "../pipe/url-string.pipe";
import { ModalModule } from 'ngx-bootstrap';


@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot()
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    ProductComponent,
    MenuComponent,
    HotMenuComponent,
    SearchMenuComponent,
    UserSuggestComponent,
    DealSuggestComponent,
    TopComponent,
    ProductGroupMenuComponent,

    //pipe
    SubStringPipe,
    CostFormatPipe,
    UrlStringPipe
  ],
  providers: [
    CookieService,
    HeaderService,
    HttpService,
    ShopCookieService
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    ProductComponent,
    MenuComponent,
    HotMenuComponent,
    TopComponent,
    UserSuggestComponent,
    DealSuggestComponent,
    ProductGroupMenuComponent,
    /*Form module*/
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    //pipe
    SubStringPipe,
    CostFormatPipe,
    UrlStringPipe
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule {
}
