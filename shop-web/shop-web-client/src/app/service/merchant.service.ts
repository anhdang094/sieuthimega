/**
 * Created by anhdx on 08/06/2017.
 */
import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class MerchantService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }


  public getMerchantInfor(merchantId: number): Promise<any> {
    return this.getAPI('api/merchants/' + merchantId);
  }

}
