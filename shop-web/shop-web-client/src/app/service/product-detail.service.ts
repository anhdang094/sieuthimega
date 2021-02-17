/**
 * Created by anhdx on 08/06/2017.
 */
import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ProductDetailService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }


  public getProductMoreByProductId(productIds: string): Promise<any> {
    return this.getAPI('api/products/suggesstion?productIds=' + productIds);
  }

  public getProductInforByProductId(productId: number): Promise<any> {
    return this.getAPI('api/products/infor?productId=' + productId);
  }

  public getProductBaseByProductId(productId: number): Promise<any> {
    return this.getAPI('api/products/' + productId);
  }

  public getProductOfMerchantsByMerchantId(merchantId: number, page: number, pageSize: number): Promise<any> {
    return this.getAPI('api/products/merchants?merchantId=' + merchantId + "&page=" + page + "&pageSize=" + pageSize);
  }

  public getAllCommentOfProduct(productId: number, page: number, pageSize: number): Promise<any> {
    return this.getAPI('api/products/comments?productId=' + productId + "&page=" + page + "&pageSize=" + pageSize);
  }

  public buildBackEndUrl(): string {
    return this.env.url;
  }

}
