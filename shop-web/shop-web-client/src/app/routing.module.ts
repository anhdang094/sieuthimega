import {NgModule} from '@angular/core';
import {RouterModule, Routes, UrlSegment} from '@angular/router';
import {ProductDetailComponent} from './component/product-detail.component';
import {CartComponent} from './component/cart.component';
import {BillingComponent} from './component/billing.component';
import {NotFoundComponent} from './component/not-found.component';
import {HomepageComponent} from './component/homepage.component';
import {ThietbiDientuComponent} from "./component/menu/thietbi-dientu.component";
import {ThoitrangNuComponent} from "./component/menu/thoitrang-nu.component";
import {ThoitrangNamComponent} from "./component/menu/thoitrang-nam.component";
import {NhaBepComponent} from "./component/menu/nha-bep.component";
import {GiayTuixachComponent} from "./component/menu/giay-tuixach.component";
import {CameraComponent} from "./component/menu/camera.component";
import {LinhkienMaytinhComponent} from "./component/menu/linhkien-maytinh.component";
import {NoithatGiadungComponent} from "./component/menu/noithat-giadung.component";
import {MeVaBeComponent} from "./component/menu/me-va-be.component";
import {ChoDocuComponent} from "./component/menu/cho-docu.component";
import {URL_PRODUCT} from "./constant/common.constant";
import {SuccessComponent} from "./component/success.component";

export function productUrl(segments: UrlSegment[]) {
  return (URL_PRODUCT.includes(segments[0].path) && segments[1]) ? ({consumed: segments}) : null;
}

const routes: Routes = [
  //menu
  {path: '', component: HomepageComponent},
  {path: 'thietbi-dientu', component: ThietbiDientuComponent},
  {path: 'thoitrang-nu', component: ThoitrangNuComponent},
  {path: 'thoitrang-nam', component: ThoitrangNamComponent},
  {path: 'nha-bep', component: NhaBepComponent},
  {path: 'giay-tuixach', component: GiayTuixachComponent},
  {path: 'camera', component: CameraComponent},
  {path: 'linh-kien-may-tinh', component: LinhkienMaytinhComponent},
  {path: 'noithat-giadung', component: NoithatGiadungComponent},
  {path: 'me-va-be', component: MeVaBeComponent},
  {path: 'cho-do-cu', component: ChoDocuComponent},
  //other
  {matcher: productUrl, component: ProductDetailComponent},
  {path: 'muahang', component: CartComponent},
  {path: 'thanhtoan', component: BillingComponent},
  {path: 'thanhcong', component: SuccessComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { scrollPositionRestoration: 'enabled' })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
