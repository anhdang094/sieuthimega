import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {HomePageService} from "../../service/homepage.service";
import {Menu} from "../../model/menu.model";
import {MenuSub} from "../../model/menu-sub.model";

@Component({
  selector : 'product-group-menu',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/product-group-menu.html'
})

export class ProductGroupMenuComponent implements AfterViewInit {

  constructor(private homePageService : HomePageService) {
  }

  @Input() menuGroups: MenuSub[];

  ngAfterViewInit(): void {
  }

}
