import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.css'],
  providers: [ApiService]
})
export class OrderItemComponent implements OnInit {

  content = null;
  constructor(private apiService: ApiService) {
    this.content = this.apiService.getSampleOrders();
    console.log( 'aa' + this.content);
  }


  ngOnInit(): void {
    this.content = this.apiService.getSampleOrders();
    console.log( 'ff' + this.content);
  }
}
