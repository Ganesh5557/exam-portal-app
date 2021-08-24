import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {


  constructor(private http: HttpClient, private route: Router) { }


  // subject (event) for updating navbar buttons based on whether 
  // the user is logged in or logged out 
  public loginStatusSubject = new Subject<boolean>();
  public logoutStatusSubject = new Subject<boolean>();

  // authenticating the user and generating the token
  authenticate(registeredUser: any) {
    console.log(registeredUser);

    return this.http.post(`${environment.baseUrl}/authenticate`, registeredUser);
  }

  // Setting the token in the localstorage once the  user is logged in
  public setUserinLocal(token: string) {
    localStorage.setItem("token", token)
    // this.loginStatusSubject.next(true);  You can fire this subject from login component as well
    return true;
  }

  // Checking whether the user is logged in or not
  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token"); // we get the string
    if (tokenStr == undefined || tokenStr == null || tokenStr == "") {
      return false
    } else { return true }
  }

  // logOut: remove token from local storage
  public logout() {
    localStorage.removeItem("token");
    this.logoutStatusSubject.next(true);

    return true
  }

  // get token
  public getToken() {
    return localStorage.getItem("token");
  }

  // set userDetails in the local storage to prevent server calls numerous time
  public setUser(user: any) {
    localStorage.setItem("user", JSON.stringify(user));
  }

  // get User from the local Storage 
  public getUser() {
    let userStr = localStorage.getItem("user");
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  // get user role
  public getUserRole() {
    let user = this.getUser()
    return user.authorities[0].authority;
  }

  // get current user who has successfully authenticated and has a token
  // This is not the endpoint which can be accessed without sending the authorization, so need to add angular interceptor
  public getCurrentUser() {
    return this.http.get(`${environment.baseUrl}/current-user`);
  }

  public getAllUsers() {
    return this.http.get(`${environment.baseUrl}/`);
  }

}
