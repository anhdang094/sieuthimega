import {Component, Input, OnInit} from '@angular/core';
import {Search} from "../../model/search/search.model";

@Component({
  selector: 'app-search-menu',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/elements/search-menu.html'
})

export class SearchMenuComponent implements OnInit {
  @Input() menu: Search;

  constructor() {
  }

  ngOnInit() {
  }

}
