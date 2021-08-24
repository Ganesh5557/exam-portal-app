import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

import { LoginUserService } from 'src/app/services/login/login-user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userDetails: any;
  headers = ["firstName", "lastName", "email", "userName", "phone", "profile"]
  rows: any;
  constructor(private userSer: LoginUserService) { }

  ngOnInit(): void {
    this.rows = ((this.userSer.getUser()))
    console.log(this.headers[0]);
    console.log(this.rows[this.headers[0]]);


    // {{rows[[headers[0]]}}
    console.log();







    // .subscribe(
    //   (data) => {
    //     alert("done")
    //     console.log(data);

    //   },
    //   (error) => {
    //     alert("error")
    //     console.log(error);

    //   }
    // );
  }
}

