/**
 * Created by anhdx on 08/06/2017.
 */
import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ManagementService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public getHomeForYouProduct(): Promise<any> {
    return this.getAPI('api/products/home?type=3');
  }

  public registerProduct(data: any): Promise<any> {
    return this.postAPI('api/products', data);
  }

  public buildBackEndUrl(): string {
    return this.env.url;
  }

}
