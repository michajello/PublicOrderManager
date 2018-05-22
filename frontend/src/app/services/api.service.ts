import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from '@angular/http';
// import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const API_URL = environment.apiUrl;

@Injectable()
export class ApiService {

  constructor(private http: Http) { }

  public getSampleOrders() {
    return this.http
      .get(API_URL)
      .map(response => {
        console.log('dsds' + response.json());
        response.json();
        }
      );
  }
}
