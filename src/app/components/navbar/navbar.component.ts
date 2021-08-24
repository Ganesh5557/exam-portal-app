import { Component, OnInit } from '@angular/core';
import { LoginUserService } from 'src/app/services/login/login-user.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;
  user = null;

  constructor(public loginSer: LoginUserService, private router: Router) { }

  ngOnInit(): void {
    this.isLoggedIn = this.loginSer.isLoggedIn();
    this.user = this.loginSer.getUser();

    // subscribing to the subject fired from the login component
    this.loginSer.loginStatusSubject.asObservable().subscribe(
      (data) => {
        this.isLoggedIn = this.loginSer.isLoggedIn();
        this.user = this.loginSer.getUser();
      }
    )

  }

  

  public logOut() {
    this.loginSer.logoutStatusSubject.asObservable().subscribe(
      (data: boolean) => {
        console.log(data);

        this.isLoggedIn = (this.loginSer.isLoggedIn());
        this.user = null
      })

    this.loginSer.logout();
    this.router.navigate(["login"]);
    // reloading if used window,location
    // window.location.reload();






  }

}
