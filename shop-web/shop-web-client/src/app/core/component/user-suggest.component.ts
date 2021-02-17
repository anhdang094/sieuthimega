import {AfterViewInit, Component} from '@angular/core';
import {Collection} from "../../model/collection.model";
import {HomePageService} from "../../service/homepage.service";

@Component({
  selector: 'app-product-suggest',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/user-suggest.html'
})

export class UserSuggestComponent implements AfterViewInit {

  constructor(private homePageService: HomePageService) {
  }

  collections: Collection[] = [];
  url: string;

  ngAfterViewInit() {
    this.homePageService.getCollections().then(result => {
      this.collections = result.data;
    });
    this.url = this.homePageService.buildBackEndUrl();
  }
}
