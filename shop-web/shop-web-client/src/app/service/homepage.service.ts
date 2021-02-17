/**
 * Created by anhdx on 08/06/2017.
 */
import {Injectable} from '@angular/core';
import {HttpService} from './http.service';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HomePageService extends HttpService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public getMenu(): Promise<any> {
    return this.getAPI('api/menu');
  }

  public getAllPromotion(): Promise<any> {
    return this.getAPI('api/promotions');
  }

  public getDefaultFee(): Promise<any> {
    return this.getAPI('api/configs/fee');
  }

  public getSlide(): Promise<any> {
    return this.getAPI('api/slide');
  }

  public getMenuByDate(): Promise<any> {
    return this.getAPI('api/menu-by-date');
  }

  public getBestBuy(): Promise<any> {
    return this.getAPI('api/best-buy');
  }

  public getAdsImageHeaderIds(): Promise<any> {
    return this.getAPI('images/ads?type=1');
  }

  public getAdsImageLeftIds(): Promise<any> {
    return this.getAPI('images/ads?type=2');
  }

  public getAdsImageProductGroupIds(type: number): Promise<any> {
    return this.getAPI('images/ads?type=' + type);
  }

  public getCollections(): Promise<any> {
    return this.getAPI('api/collections');
  }

  public getQuickDeal(): Promise<any> {
    return this.getAPI('api/quick-deal');
  }

  public getHomeBaseProduct(): Promise<any> {
    return this.getAPI('api/products/home?type=1');
  }

  public getHomeHotProduct(): Promise<any> {
    return this.getAPI('api/products/home?type=2');
  }

  public getHomeForYouProduct(): Promise<any> {
    return this.getAPI('api/products/home?type=3');
  }

  public postFeedback(data: any): Promise<any> {
    return this.postAPI('api/feedbacks', data);
  }

  public buildBackEndUrl(): string {
    return this.env.url;
  }

}
