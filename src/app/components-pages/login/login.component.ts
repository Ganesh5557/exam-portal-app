import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { UserService } from 'src/app/services/user.service';
import { LoginUserService } from 'src/app/services/login/login-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registeredUser = {
    username: "",
    password: ""
  }
  constructor(private loginuserSer: LoginUserService, private _snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }
  formSubmit() {

    // VALIDATE THE input
    if (this.registeredUser.username.trim() == "" || this.registeredUser.password.trim() == "") {
      this._snack.open("Please fill  the required fields", "Dismiss", { duration: 3000 })
      return
    }

    // Authenticate and generate token method
    this.loginuserSer.authenticate(this.registeredUser).subscribe(
      // success
      (data: any) => {
        console.log(data);
        this._snack.open("Log in Success", "Dismiss", {
          duration: 3000
        })

        // Once the user  is authenticated, we will save the token of the user to the localStorage
        this.loginuserSer.setUserinLocal(data.token)

        // getting the details of the current logged in user and setting it in the localstorage
        this.loginuserSer.getCurrentUser().subscribe(
          // success
          (data: any) => {
            console.log(data);
            // setting the user from the server to the localstorage
            this.loginuserSer.setUser(data)

            // redirect ADMIN to admin dashboard
            // redirect NORMAL to admin dashboard
            if (this.loginuserSer.getUserRole() == "ADMIN") {
              // redirect ADMIN to admin dashboard
              // window.location.href = "/admin"

              this.router.navigate(["admin"]);
              this.loginuserSer.loginStatusSubject.next(true);


            } else if (this.loginuserSer.getUserRole() == "NORMAL") {
              // redirect ADMIN to admin dashboard
              // window.location.href = "/user"
              this.router.navigate(["user"]);
              this.loginuserSer.loginStatusSubject.next(true);

            } else {
              // logging out the user
              this.loginuserSer.logout();

            }

          },
          error => {
            console.log(error);
            this._snack.open("Invalid Details !! Try again ", "Dismiss", { duration: 3000 })
          }


        )


      },
      (error) => {
        console.log(error);
        this._snack.open("Invalid Credentials", "Dismiss", {
          duration: 5000
        })
      }
    )
  }
}
