import {AfterViewInit, Component, Input} from '@angular/core';
import {Router} from "@angular/router";
import {ShopCookieService} from "../../service/cookie.service";
import {BaseProduct} from "../../model/base-product.model";


@Component({
  selector: 'app-product',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/product.html'
})

export class ProductComponent implements AfterViewInit {

  constructor(private router: Router, private cookieService: ShopCookieService) {
  }

  ngAfterViewInit() {
  }

  @Input() product: BaseProduct;
  @Input() url: string;

  addToCart() {
    this.cookieService.addProductToCart(this.product);
    this.router.navigate(['/muahang']);
  }

}
