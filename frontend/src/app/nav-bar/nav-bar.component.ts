import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  loggedIn: Boolean = false;

  constructor(private router: Router, public authService: AuthService) { }

  ngOnInit() {
  }

  orders() {
    this.router.navigateByUrl('/orders');
  }

  home() {
    this.router.navigateByUrl('/');
  }

  register() {
    this.router.navigateByUrl('/register');
  }

  login() {
    this.router.navigateByUrl('/login');
  }

  myOrders() {

  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/');
  }
}
