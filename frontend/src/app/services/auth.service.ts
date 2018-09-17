import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import {User} from '../model/User';
import { JwtHelperService} from '@auth0/angular-jwt';
import {Observable} from 'rxjs';
import {SimplifiedOrder} from '../model/SimplifiedOrder';

const AUTH_PATH = '/login';
const helper = new JwtHelperService();


@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }
  public loggedIn: Boolean = false;
  public user: User;
  private jwt: string;
  public authenticate(username: String, password: String): Observable<HttpResponse<any>> {
    return this.http.post(environment.SERVER_URL + AUTH_PATH, { 'username': username, 'password': password },
      { observe: 'response' });
  }
  public async login(username: String, password: String): Promise<Boolean> {
    await this.authenticate(username, password).subscribe(resp => {
      if (resp.ok) {
        this.jwt = resp.headers.get('Authorization');
        const decodedJWT = helper.decodeToken(this.jwt.replace('Bearer', ''));
        const httpOptions = {
          headers: new HttpHeaders({
            'Authorization': this.jwt
          }),
          response: 'observe'
        };
        this.http.get<User>(environment.SERVER_URL + '/users/' + decodedJWT.id, httpOptions).subscribe(user => {
          this.user = user;
          this.loggedIn = true;
          console.log(user);
        });
      } else {
        this.loggedIn = false;
      }
    });
    return this.loggedIn;
  }
  public logout() {
    this.user = null;
    this.loggedIn = false;
    this.jwt = '';
  }
  public removeFromObserving(id: number) {
    const index = this.user.observing.indexOf(id);
    if (index !== -1) {
      this.user.observing.splice(index, 1);
    }
  }
  public addToObserving(id: number) {
    this.user.observing.push(id);
  }
  public saveObserving() {
    this.http.put(
      environment.SERVER_URL + '/users/' + this.user.id + '/observing',
      {'observing': this.user.observing}, {
        headers: new HttpHeaders({'Authorization': this.jwt}),
        observe: 'response'
      }
    ).subscribe( resp => {
        if (resp.ok) {
          console.log('ok');
        }
    });
  }
  public getUserObserving() {
    return this.http.get<SimplifiedOrder[]>(environment.SERVER_URL + /users/ + this.user.id + '/observing', {
      headers: new HttpHeaders({'Authorization': this.jwt}),
      observe: 'response'
    });
  }
}
