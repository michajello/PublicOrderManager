import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { SimplifiedOrder } from '../model/SimplifiedOrder';
import { OrderSejmometr } from '../model/OrderSejmometr';


const SEJMOMETR_API_URL = environment.SEJMOMETR_URL;
const API_URL = environment.ORDER_URL;
const PAGE_VAR = environment.pageVar;
const SIZE_VAR = environment.sizeVar;
const ID_VAR = environment.idVar;


@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  public getSampleOrders(page: number, size: number) {
    return this.http
      .get<SimplifiedOrder[]>(API_URL.replace(PAGE_VAR, String(page)).replace(SIZE_VAR, String(size)));
  }

  public getSejmometrOrderDetails(id: number) {
    return this.http
    .get<OrderSejmometr>(SEJMOMETR_API_URL.replace(ID_VAR, String(id)));
  }
}
