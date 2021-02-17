import {AfterViewInit, Component} from '@angular/core';
import {HomePageService} from "../../service/homepage.service";
import {QuickDeal} from "../../model/quick-deal.model";

@Component({
  selector: 'app-deal-suggest',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/deal-suggest.html'
})

export class DealSuggestComponent implements AfterViewInit {
  constructor(private homePageService: HomePageService) {
  }

  dealSuggest: QuickDeal[] = [];
  url: string;

  ngAfterViewInit(): void {
    this.homePageService.getQuickDeal().then(result => {
      this.dealSuggest = result.data;
    });
    this.url = this.homePageService.buildBackEndUrl();
  }
}
