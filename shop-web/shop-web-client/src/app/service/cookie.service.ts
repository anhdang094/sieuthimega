import {Injectable} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import * as _ from 'lodash';
import {BaseProduct} from "../model/base-product.model";

@Injectable()
export class ShopCookieService {
  constructor(private cookieService: CookieService) {
  }

  addProductToCart(product: BaseProduct) {
    let products: BaseProduct[] = [];
    let result = this.cookieService.get('productsInCart');
    if (result) {
      products = JSON.parse(result);
      let pd = _.find(products, p => p.product.id === product.product.id);
      if (pd) {
        pd.quantity = pd.quantity + 1;
      } else {
        product.quantity = 1;
        products.push(product);
      }
    } else {
      product.quantity = 1;
      products.push(product);
    }
    this.cookieService.set('productsInCart', JSON.stringify(products));
  }

  removeProductToCart(product: BaseProduct) {
    let products: BaseProduct[] = [];
    let result = this.cookieService.get('productsInCart');
    if (result) {
      products = JSON.parse(result);
      let pd = _.find(products, p => p.product.id === product.product.id);
      if (pd.quantity > 1) {
        pd.quantity = pd.quantity - 1;

      } else {
        let pd = _.find(products, p => p.product.id === product.product.id);
        products = _.reject(products, function (el) {
          return el.product.id === pd.product.id;
        });
      }

    } else {
      let pd = _.find(products, p => p.product.id === product.product.id);
      products = _.reject(products, function (el) {
        return el.product.id === pd.product.id;
      });
    }
    this.cookieService.set('productsInCart', JSON.stringify(products));
  }

  deleteProductToCart(product: BaseProduct) {
    let products: BaseProduct[] = [];
    let result = this.cookieService.get('productsInCart');
    if (result) {
      products = JSON.parse(result);
      let pd = _.find(products, p => p.product.id === product.product.id);
      products = _.reject(products, function (el) {
        return el.product.id === pd.product.id;
      });
    }
    this.cookieService.set('productsInCart', JSON.stringify(products));
  }

  getAllProductsInCart(): BaseProduct[] {
    return JSON.parse(this.cookieService.get('productsInCart'));
  }
}
