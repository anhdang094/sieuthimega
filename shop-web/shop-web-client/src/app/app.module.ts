import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {CoreModule} from './core/core.module';
import {BillingComponent} from './component/billing.component';
import {CartComponent} from './component/cart.component';
import {HomepageComponent} from './component/homepage.component';
import {NotFoundComponent} from './component/not-found.component';
import {ProductDetailComponent} from './component/product-detail.component';
import {ThietbiDientuComponent} from "./component/menu/thietbi-dientu.component";
import {HomePageService} from "./service/homepage.service";
import {CameraComponent} from "./component/menu/camera.component";
import {ChoDocuComponent} from "./component/menu/cho-docu.component";
import {GiayTuixachComponent} from "./component/menu/giay-tuixach.component";
import {LinhkienMaytinhComponent} from "./component/menu/linhkien-maytinh.component";
import {MeVaBeComponent} from "./component/menu/me-va-be.component";
import {NhaBepComponent} from "./component/menu/nha-bep.component";
import {NoithatGiadungComponent} from "./component/menu/noithat-giadung.component";
import {ThoitrangNamComponent} from "./component/menu/thoitrang-nam.component";
import {ThoitrangNuComponent} from "./component/menu/thoitrang-nu.component";
import {ProductGroupService} from "./service/product-group.service";
import {ProductDetailService} from "./service/product-detail.service";
import {MerchantService} from "./service/merchant.service";
import {SuccessComponent} from "./component/success.component";


@NgModule({
  declarations: [
    //component
    AppComponent,
    BillingComponent,
    CartComponent,
    HomepageComponent,
    NotFoundComponent,
    SuccessComponent,
    ProductDetailComponent,

    //menu
    CameraComponent,
    ChoDocuComponent,
    GiayTuixachComponent,
    LinhkienMaytinhComponent,
    MeVaBeComponent,
    NhaBepComponent,
    NoithatGiadungComponent,
    ThietbiDientuComponent,
    ThoitrangNamComponent,
    ThoitrangNuComponent,
  ],
  imports: [
    BrowserModule,
    CoreModule
  ],
  providers: [
    //service
    HomePageService,
    ProductGroupService,
    ProductDetailService,
    MerchantService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
