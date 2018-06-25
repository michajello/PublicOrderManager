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

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.apiService.getSampleOrders(1, 20).subscribe(orders => {
      this.simplifiedOrders = orders;
    });
  }

}
