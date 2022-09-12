import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './myComponents/dashboard/dashboard.component';
import { HomeComponent } from './myComponents/home/home.component';
import { RegistrationComponent } from './myComponents/registration/registration.component';

const routes: Routes = [
  {
    path: "registration",
    component: RegistrationComponent,
    pathMatch: "full"
  },
  {
    path: "dashboard",
    component: DashboardComponent,
    pathMatch: "full"
  },
  {
    path: "",
    component: HomeComponent,
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
