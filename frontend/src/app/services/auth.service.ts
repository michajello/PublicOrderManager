import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import {Observable} from 'rxjs';

const AUTH_PATH = '/login';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }
  public loggedIn: Boolean = false;
  private jwt: String;
  public getJwt(): String {
    return this.jwt;
  }
  public authenticate(username: String, password: String): Observable<HttpResponse<Object>> {
    return this.http.post(environment.SERVER_URL + AUTH_PATH, { 'username': username, 'password': password },
      { observe: 'response' });
  }
  public async login(username: String, password: String): Promise<Boolean> {
    await this.authenticate(username, password).subscribe(resp => {
      if (resp.ok) {
        this.loggedIn = true;
        this.jwt = resp.headers.get('Authorization');
      } else {
        this.loggedIn = false;
      }
    });
    return this.loggedIn;
  }
  public logout() {
    this.loggedIn = false;
    this.jwt = '';
  }
}
