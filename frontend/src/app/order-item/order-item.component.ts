import { Component, OnInit, Input } from '@angular/core';
import { SimplifiedOrder } from '../model/SimplifiedOrder';
import { ApiService } from '../services/api.service';
import { OrderSejmometr } from '../model/OrderSejmometr';
import { OrderDetails } from '../model/OrderDetailsSejmometr';


@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.css'],
  providers: [ApiService],
})
export class OrderItemComponent implements OnInit {
  @Input() simplifiedOrder: SimplifiedOrder;

  orderDetails: OrderDetails ;
  detailsDisplayed: Boolean;

  constructor(private apiService: ApiService) {
    this.detailsDisplayed = false;
  }


  ngOnInit(): void {
    this.apiService.getSejmometrOrderDetails(this.simplifiedOrder.id).subscribe(order => {
      this.orderDetails = order.data;
      console.log(this.orderDetails);
    });
  }

  onSelect(): void {
    this.detailsDisplayed === false ? this.detailsDisplayed = true : this.detailsDisplayed = false;
  }

}
