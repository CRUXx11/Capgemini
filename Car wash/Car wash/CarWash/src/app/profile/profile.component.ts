import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../signup/customer';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  
  name=localStorage.getItem('name');
  email=localStorage.getItem('email');
  contact=localStorage.getItem('contact');

  signinstatus:boolean;
  constructor(private router:Router) { }

  public checklogin(){
    if(localStorage.getItem('email')===null){
      this.router.navigate(["signup"])
    }
    else{
      this.router.navigate(["profile"]);
    }
  }
  ngOnInit(): void {
    
  }
  public logout(){
    localStorage.clear();
    window.alert("Logged Out Successfully")
    this.router.navigate(["home"]);
  }

}
