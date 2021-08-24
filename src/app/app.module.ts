import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatImportsModule } from './mat-imports/mat-imports.module';
import { HomeComponent } from './components-pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components-pages/login/login.component';
import { SignupComponent } from './components-pages/signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { authInterceptorProviders } from './services/interceptor/auth.interceptor';
import { AdminDashboardComponent } from './components-pages/admin/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './components-pages/user/user-dashboard/user-dashboard.component';
import { SidenavComponent } from './components-pages/admin/sidenav/sidenav.component';
import { ProfileComponent } from './components-pages/admin/profile/profile.component';
import { QuizComponent } from './components-pages/admin/quiz/quiz.component';
import { CategoryComponent } from './components-pages/admin/category/category.component';
import { NavComponent } from './components/nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { AddCategoryComponent } from './components-pages/admin/add-category/add-category.component';
import { AddQuizComponent } from './components-pages/admin/add-quiz/add-quiz.component';
import { UpdateCategoryComponent } from './components-pages/admin/update-category/update-category.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    SidenavComponent,
    ProfileComponent,
    QuizComponent,
    CategoryComponent,
    NavComponent,
    AddCategoryComponent,
    AddQuizComponent,
    UpdateCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatImportsModule,
    FormsModule,
    HttpClientModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,



  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
