/**
 * Created by anhdx on 08/06/2017.
 */
import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ProductGroupService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public getMenuGroup(filter: string): Promise<any> {
    return this.getAPI('api/menu-group?filter=' + filter);
  }

  public getProductByMenu(filter: string, page: number, pageSize: number): Promise<any> {
    return this.getAPI('api/products?filter=' + filter + '&page=' + page + "&pageSize=" + pageSize);
  }

  public buildBackEndUrl(): string {
    return this.env.url;
  }

}
