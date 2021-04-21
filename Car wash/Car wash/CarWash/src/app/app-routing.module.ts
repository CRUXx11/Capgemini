import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { ServicespageComponent } from './servicespage/servicespage.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ProfileComponent } from './profile/profile.component';
import { PriceComponent } from './price/price.component';
import { AdminComponent } from './admin/admin.component';
import { HfooterComponent } from './hfooter/hfooter.component';
import { HeaderComponent } from './header/header.component';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import { AboutusComponent } from './aboutus/aboutus.component';

const routes: Routes = [
  {path:"",redirectTo:"/home",pathMatch:'full'},
  {path:"home",component:HomeComponent},
  { path: "signup", component: SignupComponent },
  { path: "signin", component: SigninComponent },
  {path:"services",component:ServicespageComponent},
  {path:"contactus",component:ContactusComponent},
  {path:"profile",component:ProfileComponent},
  {path:"price",component:PriceComponent},
  {path:"admin",component:AdminComponent},
  {path:"about",component:AboutusComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingcomponents =[HomeComponent,SignupComponent,SigninComponent,
                                 ContactusComponent, ServicespageComponent,ProfileComponent,
                                 PriceComponent,AdminComponent,HfooterComponent,
                                 HeaderComponent,DialogBoxComponent,AboutusComponent]