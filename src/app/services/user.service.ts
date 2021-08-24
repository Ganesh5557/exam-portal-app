import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { environment } from "../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient) { }
  formSubmitBackend(user: User) {
    return this.http.post(`${environment.baseUrl}/users/`, user);
  }

}
