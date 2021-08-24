import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { LoginUserService } from 'src/app/services/login/login-user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  isLoggedIn = false;
  user = null;
  mobile = false

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, public loginSer: LoginUserService, private router: Router) { }





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
  }
}