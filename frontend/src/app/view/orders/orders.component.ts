import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { SimplifiedOrder } from '../../model/SimplifiedOrder';

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

  constructor(private apiService: ApiService) {
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
      this.finishDate, this.voivodeship, this.orderKind, this.orderType, this.orderMode).subscribe(orders => {
      this.simplifiedOrders = orders;
    });
  }

}
