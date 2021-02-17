import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable()
export class HeaderService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public getMenu(): Promise<any> {
    return this.getAPI('api/search/menu');
  }

  public searchProduct(term): Promise<any> {
    return this.getAPI(`api/products/filters?name=` + term);
  }

}
