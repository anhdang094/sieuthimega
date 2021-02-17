import {Component, OnInit} from '@angular/core';
import {ShopCookieService} from "../service/cookie.service";
import {BaseProduct} from "../model/base-product.model";
import {HomePageService} from "../service/homepage.service";
import {Router} from "@angular/router";
import * as _ from 'lodash';
import {Promotion} from "../model/promotion.model";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {formFieldValidation} from "../core/validation/form-field.validation";

@Component({
  selector: 'app-card',
  templateUrl: '../view/cart.html'
})

export class CartComponent implements OnInit {
  constructor(private cookieService: ShopCookieService, private homePageService: HomePageService,
              private router: Router, private formBuilder: FormBuilder) {
  }

  url: string;
  products: BaseProduct[] = [];
  sumAmount: number = 0;
  defaultFee: number = 0;
  voucherAmount: number = 0;
  promotions: Promotion[] = [];
  inputForm: FormGroup;
  submitted = false;
  invalid = true;

  ngOnInit(): void {
    this.url = this.homePageService.buildBackEndUrl();
    this.getPromotionIsActive();
    this.inputForm = this.formBuilder.group({
      promotionCode: ['', this.validatePromotion.bind(this)],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]\d*$/)]],
      address: ['', Validators.required],
      notice: ['', []],
    });
    this.reloadProduct();
    this.getDefaultFee();
    this.getPromotionIsActive();
  }

  validatePromotion(control: AbstractControl) {
    if (this.promotions.length > 0) {
      this.invalid = !this.promotions.map(item => item.code).includes(control.value);
      return this.invalid && control.value.length > 0 ? {'invalid': {value: control.value}} : null;
    }
  }

  calculatePromotion() {
    let promotionCode = this.inputForm.getRawValue().promotionCode;
    if (!this.invalid) {
      let promotionFilters = this.promotions.filter(item => item.code == promotionCode);
      if (promotionFilters.length > 0) {
        let promotion = promotionFilters[0];
        if (promotion.fixValue && promotion.fixValue != 0) {
          this.voucherAmount = promotion.fixValue;
        } else {
          this.voucherAmount = promotion.percentValue * this.sumAmount / 100;
        }
      }
    } else {
      if (!promotionCode) {
        this.voucherAmount = 0;
      }
    }
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.inputForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.inputForm.invalid) {
      return;
    } else {
      this.checkout();
    }
  }

  getPromotionIsActive() {
    this.homePageService.getAllPromotion().then(result => {
      this.promotions = result.data;
    });
  }

  getDefaultFee() {
    this.homePageService.getDefaultFee().then(result => {
      this.defaultFee = result.data;
    });
  }

  reloadProduct() {
    this.products = this.cookieService.getAllProductsInCart();
    this.sumAmount = _.reduce(this.products, function (memo, product) {
      return memo + product.product.cost * product.quantity;
    }, 0);
  }

  decreaseNumProduct(product: BaseProduct) {
    this.cookieService.removeProductToCart(product);
    this.reloadProduct();
  }

  increaseNumProduct(product: BaseProduct) {
    this.cookieService.addProductToCart(product);
    this.reloadProduct();
  }

  delete(product: BaseProduct) {
    this.cookieService.deleteProductToCart(product);
    this.reloadProduct();
  }

  checkout() {
    this.router.navigate(['/thanhtoan']);
  }

}
