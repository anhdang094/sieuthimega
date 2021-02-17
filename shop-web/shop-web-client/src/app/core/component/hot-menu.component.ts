import {Component, Input, OnInit} from '@angular/core';
import {BestBuy} from "../../model/best-buy.model";

@Component({
  selector: 'app-hot-menu',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/hot-menu.html'
})

export class HotMenuComponent implements OnInit {

  @Input() menu: BestBuy;

  constructor() {
  }

  ngOnInit() {
  }

}
