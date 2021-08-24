import { HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUserService } from '../login/login-user.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private login: LoginUserService) { }

    intercept(req: import("@angular/common/http").HttpRequest<any>, next: import("@angular/common/http").HttpHandler): import("rxjs").Observable<import("@angular/common/http").HttpEvent<any>> {
        // add the jwt token from (localstorage) to every request(req)
        const token = this.login.getToken();

        let authReq = req
        console.log(token);

        if (token != null) {
            console.log("reached");
            authReq = authReq.clone(
                {


                    setHeaders: { Authorization: `Bearer ${token}` }
                }
            );
        }
        return next.handle(authReq);

    }
}

export const authInterceptorProviders = [
    {
        provide: HTTP_INTERCEPTORS,
        useClass: AuthInterceptor,
        multi: true,
    }
]