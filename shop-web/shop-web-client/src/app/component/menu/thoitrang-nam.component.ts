import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HomePageService} from "../../service/homepage.service";
import {ProductGroupService} from "../../service/product-group.service";
import {MenuSub} from "../../model/menu-sub.model";
import {BaseProduct} from "../../model/base-product.model";
/**
 * Created by anhdx on 08/06/2017.
 */
@Component({
  selector : 'thoitrang-nam',
  styleUrls: ['../../style/group-product.css'],
  templateUrl: '../../view/menu/thoitrang-nam.html'
})

export class ThoitrangNamComponent implements AfterViewInit {
  constructor(private homePageService: HomePageService, private productGroupService: ProductGroupService) {
  }

  adsImageHeaderIds: number[] = [];
  menuGroups: MenuSub[] = [];
  products: BaseProduct[] = [];
  totalPages: number[] = null;
  currentPage: number = null
  url: string = null;

  ngAfterViewInit(): void {
    this.homePageService.getAdsImageProductGroupIds(12).then(result => {
      this.adsImageHeaderIds = result.data;
    });
    this.productGroupService.getMenuGroup("thoitrangnam").then(result => {
      this.menuGroups = result.data;
    });
    this.onLoadPage(1);
    this.url = this.homePageService.buildBackEndUrl();
  }

  onLoadPage(page: number) {
    this.productGroupService.getProductByMenu("thoitrangnam", page, 30).then(result => {
      this.products = result.data.content;
      this.totalPages= Array(result.data.totalPages).fill(0).map((x,i)=>i+1);
      this.currentPage = result.data.pageable.pageNumber;
    });
  }
}
