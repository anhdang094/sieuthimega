import {AfterViewInit, Component} from '@angular/core';
import {Slide} from "../model/slide.model";
import {MenuSub} from "../model/menu-sub.model";
import {BestBuy} from "../model/best-buy.model";
import {HomePageService} from "../service/homepage.service";
import {BaseProduct} from "../model/base-product.model";

@Component({
  selector: 'app-homepage',
  templateUrl: '../view/shop.html',
  styleUrls: ['../style/homepage.css']
})

export class HomepageComponent implements AfterViewInit {

  slide: Slide[] = [];
  menuByDay: MenuSub[] = [];
  bestBuy: BestBuy[] = [];
  adsImageHeaderIds: number[] = [];
  adsImageLeftIds: number[] = [];
  url: string;
  baseProducts: BaseProduct[] = [];
  hotProducts: BaseProduct[] = [];
  forYouProducts: BaseProduct[] = [];
  time: Date = null;

  constructor(private homePageService: HomePageService) {
  }

  ngAfterViewInit() {
    this.homePageService.getSlide().then(result => {
      this.slide = result.data;
    });
    this.homePageService.getMenuByDate().then(result => {
      this.menuByDay = result.data;
    });
    this.homePageService.getBestBuy().then(result => {
      this.bestBuy = result.data;
    });
    this.homePageService.getAdsImageHeaderIds().then(result => {
      this.adsImageHeaderIds = result.data;
    });
    this.homePageService.getAdsImageLeftIds().then(result => {
      this.adsImageLeftIds = result.data;
    });
    this.homePageService.getHomeBaseProduct().then(result => {
      this.baseProducts = result.data;
    });
    this.homePageService.getHomeHotProduct().then(result => {
      this.hotProducts = result.data;
    });
    this.homePageService.getHomeForYouProduct().then(result => {
      this.forYouProducts = result.data;
    });
    this.url = this.homePageService.buildBackEndUrl();
    this.clock();
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

}
