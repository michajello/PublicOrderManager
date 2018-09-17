import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { SimplifiedOrder } from '../../model/SimplifiedOrder';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
  providers: [ApiService]

})
export class OrdersComponent implements OnInit {

  simplifiedOrders: SimplifiedOrder[];
  pageOffset: number;
  pageSize: number;
  startDateStr: string;
  endDateStr: string;
  startDate: Date;
  finishDate: Date;
  voivodeship: number;
  orderKind: number;
  orderMode: number;
  orderType: number;
  minEstimatedPrice: number;
  maxEstimatedPrice: number;

  constructor(private apiService: ApiService, public authService: AuthService) {
    this.pageOffset = 1;
    this.pageSize = 20;
  }

  ngOnInit() {
    this.getData();
  }

  onClickForm(): void {
    this.pageSize = this.pageSize > 100 ? 100 : this.pageSize;
    this.startDate = this.startDateStr != null ? new Date(this.startDateStr) : null;
    this.finishDate = this.endDateStr != null ? new Date(this.endDateStr) : null;
    this.minEstimatedPrice = this.minEstimatedPrice == null || this.minEstimatedPrice < 0 ? 0 : this.minEstimatedPrice;
    this.maxEstimatedPrice = this.maxEstimatedPrice == null || this.maxEstimatedPrice < 0 ? null : this.maxEstimatedPrice;
    this.getData();
  }

  onClickNext(): void {
    this.pageOffset++;
    this.getData();
  }

  onClickPrevious(): void {
    this.pageOffset--;
    this.getData();
  }

  private getData(): void {
    this.apiService.getSampleOrders(this.pageOffset, this.pageSize, this.startDate,
      this.finishDate, this.voivodeship, this.orderKind, this.orderType, this.orderMode,
      this.minEstimatedPrice, this.maxEstimatedPrice).subscribe(orders => {
        this.simplifiedOrders = orders;
      });
  }

}
