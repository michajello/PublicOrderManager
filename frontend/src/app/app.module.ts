import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OrderItemComponent } from './order-item/order-item.component';
import { ApiService } from './services/api.service';
import { OrdersComponent } from './view/orders/orders.component';



@NgModule({
  declarations: [
    AppComponent,
    OrderItemComponent,
    OrdersComponent
  ],
  imports: [
    BrowserModule, HttpClientModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent, OrderItemComponent]
})
export class AppModule { }
