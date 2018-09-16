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
const START_DATE_VAR = environment.startDateVar;
const FINISH_DATE_VAR = environment.finishDateVar;
const VOIVODESHIP_VAR =  environment.voivodeshipVar;
const ORDER_MODE_VAR =  environment.orderModeVar;
const ORDER_TYPE_VAR =  environment.orderTypeVar;
const ORDER_KIND_VAR =  environment.orderKindModeVar;
const MIN_ESTIMATED_PRICE_VAR = environment.minEstimatedPriceVar;
const MAX_ESTIMATED_PRICE_VAR = environment.maxEstimatedPriceVar;

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  private extractOnlyDate(givenDate: Date): string {
    return givenDate.toISOString().substring(0, 10);
  }

  private prepareOrderRequest(page: number, size: number, startDate: Date, endDate: Date,
    voivodeship: number, orderKind: number, orderType: number, orderMode: number,
    minEstimatedPrice: number, maxEstimatedPrice: number): string {
    let requestAddress = API_URL.replace(PAGE_VAR, String(page)).replace(SIZE_VAR, String(size));
    console.log(startDate);
    console.log(endDate);

    requestAddress = requestAddress
    .replace(START_DATE_VAR, START_DATE_VAR + (startDate != null ? this.extractOnlyDate(startDate) : ''))
    .replace(FINISH_DATE_VAR, FINISH_DATE_VAR + (endDate != null ? this.extractOnlyDate(endDate) : ''))
    .replace(VOIVODESHIP_VAR, VOIVODESHIP_VAR + (voivodeship != null ? voivodeship : ''))
    .replace(ORDER_MODE_VAR, ORDER_MODE_VAR + (orderMode != null ? orderMode : ''))
    .replace(ORDER_TYPE_VAR, ORDER_TYPE_VAR + (orderType != null ? orderType : ''))
    .replace(ORDER_KIND_VAR, ORDER_KIND_VAR + (orderKind != null ? orderKind : ''))
    .replace(MIN_ESTIMATED_PRICE_VAR, MIN_ESTIMATED_PRICE_VAR + (minEstimatedPrice != null ? minEstimatedPrice : ''))
    .replace(MAX_ESTIMATED_PRICE_VAR, MAX_ESTIMATED_PRICE_VAR + (maxEstimatedPrice != null ? maxEstimatedPrice : ''));
    console.log(requestAddress);
    return requestAddress;
  }

  public getSampleOrders(page: number, size: number, startDate: Date, endDate: Date,
    voivodeship: number, orderKind: number, orderType: number, orderMode: number,
    minEstimatedPrice: number, maxEstimatedPrice: number) {
    return this.http
      .get<SimplifiedOrder[]>(this.prepareOrderRequest(page, size, startDate, endDate, voivodeship,
        orderKind, orderType, orderMode, minEstimatedPrice, maxEstimatedPrice));
  }

  public getSejmometrOrderDetails(id: number) {
    return this.http
    .get<OrderSejmometr>(SEJMOMETR_API_URL.replace(ID_VAR, String(id)));
  }
}
