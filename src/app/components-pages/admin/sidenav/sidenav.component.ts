import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginUserService } from 'src/app/services/login/login-user.service';
import { Router } from '@angular/router';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { MatMenuTrigger } from '@angular/material/menu';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {




  constructor(public logSer: LoginUserService, private route: Router, private breakpointObserver: BreakpointObserver) { }

  ngOnInit(): void {
  }

  logOut() {
    this.logSer.logout();
    this.route.navigate(["login"]);
  }
  // open Menu




  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );


}
