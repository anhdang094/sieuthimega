import {AfterViewInit, Component} from '@angular/core';
import {HeaderService} from '../../service/header.service';
import {Subject} from 'rxjs';
import {Search} from "../../model/search/search.model";
import {Product} from "../../model/product.model";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";

@Component({
  selector: 'app-header',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/header.html'
})

export class HeaderComponent implements AfterViewInit {

  constructor(private headerService: HeaderService) {
  }

  searchTerms = new Subject<any>();
  display: string = 'hidden-menu';
  showSuggestDropdown = false;
  searchMenus: Search[];
  products: Product[];

  search(term: string): void {
    this.searchTerms.next(term);
  }


  onBlurSearch() {
    this.showSuggestDropdown = false;
  }

  onFocusSearch() {
    this.showSuggestDropdown = true;
  }

  ngAfterViewInit(): void {
    this.headerService.getMenu().then(result => {
      this.searchMenus = result.data;
    });
    this.searchTerms.pipe(debounceTime(50),
      debounceTime(50),
      // ignore new term if same as previous term
      distinctUntilChanged())
      .subscribe((term: string) => {
        this.products = [];
          this.headerService.searchProduct(term).then(result => {
            this.products = result.data;
          });
        },
        error => {
          this.showSuggestDropdown = false;
          console.log(error);
        }
      );
  }
}
