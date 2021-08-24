import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components-pages/home/home.component';
import { SignupComponent } from './components-pages/signup/signup.component';
import { LoginComponent } from './components-pages/login/login.component';
import { AdminDashboardComponent } from './components-pages/admin/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './components-pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/guards/admin.guard';
import { UserGuard } from './services/guards/user.guard';
import { ProfileComponent } from './components-pages/admin/profile/profile.component';
import { QuizComponent } from './components-pages/admin/quiz/quiz.component';
import { CategoryComponent } from './components-pages/admin/category/category.component';
import { HomeComponent2 } from './components-pages/admin/home2/home2.component';
import { AddCategoryComponent } from './components-pages/admin/add-category/add-category.component';
import { AddQuizComponent } from './components-pages/admin/add-quiz/add-quiz.component';
import { UpdateCategoryComponent } from './components-pages/admin/update-category/update-category.component';

const routes: Routes = [

  { path: "", component: HomeComponent, pathMatch: "full" },
  { path: "signup", component: SignupComponent },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: AdminDashboardComponent, canActivate: [AdminGuard], children: [
      {
        path: '',
        component: HomeComponent2
      },
      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: 'quiz',
        component: QuizComponent
      },

      {
        path: 'add-quiz',
        component: AddQuizComponent
      },
      {
        path: 'category',
        component: CategoryComponent
      },
      {
        path: 'add-category',
        component: AddCategoryComponent
      }, {
        path: 'update-category/:catId',
        component: UpdateCategoryComponent
      },
    ]
  },
  { path: "user", component: UserDashboardComponent, canActivate: [UserGuard] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
