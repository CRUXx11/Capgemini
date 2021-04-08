import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { ServicespageComponent } from './servicespage/servicespage.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:"",redirectTo:"/home",pathMatch:'full'},
  {path:"home",component:HomeComponent},
  { path: "signup", component: SignupComponent },
  { path: "signin", component: SigninComponent },
  {path:"services",component:ServicespageComponent},
  {path:"contactus",component:ContactusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingcomponents =[HomeComponent,SignupComponent,SigninComponent,ServicespageComponent,ContactusComponent]