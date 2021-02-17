import {AfterViewInit, Component} from '@angular/core';
import {ProductDetailService} from "../service/product-detail.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HomePageService} from "../service/homepage.service";
import {ProductInfor} from "../model/product-infor.model";
import {BaseProduct} from "../model/base-product.model";
import {MerchantInfor} from "../model/merchant.model";
import {MerchantService} from "../service/merchant.service";
import {ShopCookieService} from "../service/cookie.service";
import {Product} from "../model/product.model";

/**
 * Created by anhdx on 08/06/2017.
 */
@Component({
  selector: 'app-product-detail',
  templateUrl: '../view/product-details.html'
})

export class ProductDetailComponent implements AfterViewInit {

  constructor(private productDetailService: ProductDetailService, private merchantService: MerchantService,
              private route: ActivatedRoute, private homePageService: HomePageService,
              private router: Router, private cookieService: ShopCookieService) {
  }

  currentProduct: Product = new Product();
  productSuggesstions: BaseProduct[] = [];
  productOfMerchants: BaseProduct[] = [];
  comments: Comment[] = [];
  productId: number;
  productInfor: ProductInfor = new ProductInfor();
  url: string;
  time: Date = null;
  imageShow: string = null;
  imageIds: string[] = [];
  merchantInfor: MerchantInfor = new MerchantInfor();

  ngAfterViewInit(): void {
    this.productId = this.route.snapshot.queryParams['filter'];
    this.clock();
    this.url = this.homePageService.buildBackEndUrl();
    this.productDetailService.getProductBaseByProductId(this.productId).then(result => {
      this.currentProduct = result.data;
    });
    this.productDetailService.getProductInforByProductId(this.productId).then(result => {
      this.productInfor = result.data;
      this.imageIds = this.productInfor.imageIds.split(',');
      this.imageShow = this.imageIds[0];
      this.getProductMerchantInfor(this.productInfor.merchantId);
      if (this.productInfor.suggest) {
        this.productDetailService.getProductMoreByProductId(this.productInfor.suggest).then(result => {
          for (let pro of result.data) {
            let baseProduct = new BaseProduct();
            baseProduct.product = pro;
            this.productSuggesstions.push(baseProduct);
          }
        });
      }
    });
  }

  addToCart() {
    let product = new BaseProduct();
    product.id = this.currentProduct.id;
    product.product = this.currentProduct;
    product.quantity = 1;
    this.cookieService.addProductToCart(product);
    this.router.navigate(['/muahang']);
  }

  // view get product-merchant
  getProductMerchantInfor(merchantId: number) {
    this.merchantService.getMerchantInfor(merchantId).then(value => {
      this.merchantInfor = value.data;
    })
  }

  getMerchant() {
    if (!this.productInfor) {
      return;
    }
    this.productDetailService.getProductOfMerchantsByMerchantId(this.productInfor.merchantId, 1, 20).then(result => {
      for (let pro of result.data.content) {
        let baseProduct = new BaseProduct();
        baseProduct.product = pro;
        this.productOfMerchants.push(baseProduct);
      }
    });
  }

  getComment() {
    this.productDetailService.getAllCommentOfProduct(this.productId, 1, 5).then(result => {
      this.comments = result.data.content;
    });
  }

  clock(): void {
    // @ts-ignore
    setInterval(() => {
      let lastTime = new Date();
      lastTime.setHours(23);
      lastTime.setMinutes(59);
      lastTime.setSeconds(59);
      let currentTime = new Date();
      // @ts-ignore
      this.time = new Date();
      this.time.setHours(lastTime.getHours() - currentTime.getHours());
      this.time.setMinutes(lastTime.getMinutes() - currentTime.getMinutes());
      this.time.setSeconds(lastTime.getSeconds() - currentTime.getSeconds());
    }, 1000);
  }

  showModalImage() {

  }

  showNextImage() {
    if (this.imageShow) {
      let index = this.imageIds.indexOf(this.imageShow);
      if (index < (this.imageIds.length - 1)) {
        index = index + 1;
        this.imageShow = this.imageIds[index];
      } else if (index == (this.imageIds.length - 1)) {
        this.imageShow = this.imageIds[0];
      }
    }
  }

  showPrevImage() {
    if (this.imageShow) {
      let index = this.imageIds.indexOf(this.imageShow);
      if (index > 0) {
        index = index - 1;
        this.imageShow = this.imageIds[index];
      } else if (index == 0) {
        this.imageShow = this.imageIds[this.imageIds.length - 1];
      }
    }
  }

  setImage(item: string) {
    this.imageShow = item;
  }


}
