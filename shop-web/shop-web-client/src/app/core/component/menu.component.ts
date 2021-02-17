import {Component, OnInit} from '@angular/core';
import {HomePageService} from "../../service/homepage.service";
import {Menu} from "../../model/menu.model";

@Component({
  selector : 'app-menu',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/menu.html'
})

export class MenuComponent implements OnInit {

  menu : Menu[] = [];

  constructor(private homePageService : HomePageService) {
  }

  ngOnInit() {
    this.homePageService.getMenu().then(result => {
      this.menu = result.data;
    });
  }

}
