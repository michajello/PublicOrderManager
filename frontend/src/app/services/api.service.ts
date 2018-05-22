import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const API_URL = environment.apiUrl;

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  public getSampleOrders() {
    return this.http
      .get(API_URL);
  }
}
