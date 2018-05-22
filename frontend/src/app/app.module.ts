import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';

import { AppComponent } from './app.component';
import { OrderItemComponent } from './order-item/order-item.component';
import { ApiService } from './services/api.service';



@NgModule({
  declarations: [
    AppComponent,
    OrderItemComponent
  ],
  imports: [
    BrowserModule, HttpModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent, OrderItemComponent]
})
export class AppModule { }
