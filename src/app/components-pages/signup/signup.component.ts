import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from "sweetalert2"

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user = new User("", "", "", "", "", "", "");
  constructor(private userSer: UserService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  formSubmit() {
    // check the inputs whether they are empty or not
    if (this.user.userName.trim() == "" || this.user.userName.trim() == null) {
      // alert("User is required");
      this._snackBar.open("Please fill all the required fields", "Close", { duration: 3000 })
      return
    }

    // add User: userService

    this.userSer.formSubmitBackend(this.user).subscribe(
      // success
      (data) => {
        console.log(data);
        Swal.fire("Success", "User is successfully registered", "success");

        this._snackBar.open("Successfully submitted the form", "Close", { duration: 3000 })

      },
      // error
      (error) => {
        console.log(error)
        alert("Sth went wrong");
        this._snackBar.open("Sth went wrong", "Close", { duration: 3000 })

      }
    )
  }

}
