import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  public label: String;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  public register(username: String, email: String, password: String) {
    this.http.post(environment.SERVER_URL + '/users', {username: username, email: email, password: password}, {observe: 'response'})
      .subscribe(resp => {
        if (resp.ok) {
          this.label = 'Success';
          this.router.navigateByUrl('/');
        } else {
          this.label = 'Error';
        }
      });
  }
}
