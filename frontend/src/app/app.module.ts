import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material';
import { RouterModule, Routes } from '@angular/router';

import { ApiService } from './services/api.service';
import { AuthService } from './services/auth.service';

import { AppComponent } from './app.component';
import { OrderItemComponent } from './order-item/order-item.component';
import { OrdersComponent } from './view/orders/orders.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

const appRoutes: Routes = [

];

@NgModule({
  declarations: [
    AppComponent,
    OrderItemComponent,
    OrdersComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, BrowserAnimationsModule, MatButtonModule
  ],
  providers: [ApiService, AuthService],
  bootstrap: [AppComponent, OrderItemComponent, NavBarComponent]
})
export class AppModule { }
