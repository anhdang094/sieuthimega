import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from "../../../environments/environment";

@Injectable()
export class HttpService {
  env = environment;

  constructor(private http: HttpClient) {
  }

  protected getAPI(url: string): Promise<any> {
    let headers = new HttpHeaders({
      'apiKey': this.env.API_KEY
    });
    url = this.env.url + url;
    return this.http.get(url, {headers: headers}).toPromise()
      .then(response => response as any)
      .catch(this.handleError);
  }

  protected postAPI(url: string, data: any): Promise<any> {
    let headers = new HttpHeaders({
      'apiKey': this.env.API_KEY
    });
    url = this.env.url + url;
    return this.http.post(url, data, {headers: headers}).toPromise()
      .then(response => response as any)
      .catch(this.handleError);
  }

  protected putAPI(url: string, data: any): Promise<any> {
    let headers = new HttpHeaders({
      'apiKey': this.env.API_KEY
    });
    url = this.env.url + url;
    return this.http.put(url, data, {headers: headers}).toPromise()
      .then(response => response as any)
      .catch(this.handleError);
  }

  protected deleteAPI(url: string): Promise<any> {
    let headers = new HttpHeaders({
      'apiKey': this.env.API_KEY
    });
    url = this.env.url + url;
    return this.http.delete(url, {headers: headers}).toPromise()
      .then(response => response as any)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
