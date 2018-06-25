import { Component, OnInit, Input } from '@angular/core';
import { SimplifiedOrder } from '../model/SimplifiedOrder';


@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.css'],
})
export class OrderItemComponent implements OnInit {
  @Input() simplifiedOrder: SimplifiedOrder;

  constructor() {
  }


  ngOnInit(): void {
    // this.content = this.apiService.getSampleOrders(1,10);
    // console.log( 'ff' + this.content);
  }
}
