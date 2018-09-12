import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

const AUTH_PATH = '/login';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  public authenticate(username: String, password: String) {
    this.http.post(environment.SERVER_URL + AUTH_PATH, { 'username': username, 'password': password }, { observe: 'response' });
  }
}
