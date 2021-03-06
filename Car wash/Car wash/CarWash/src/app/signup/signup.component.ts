import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import {SignupService} from './signup.service';
import { Customer } from './customer';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupform = true;
  usermodel:Customer= new Customer("","","","");
  submitted = false;
  errmsg = '';
  signupsuccess = "";
  workingStatus:any;
  
  constructor(private signupservice:SignupService,private router:Router) { }

  ngOnInit(): void {
  }
  public checklogin(){
    if(localStorage.getItem('email')===null){
      this.router.navigate(["signup"])
    }
    else{
      this.router.navigate(["profile"]);
    }
  }
  public onsubmit() {
    this.submitted = true;
    this.serviceupcheck();
    setTimeout(() => {
      this.router.navigate(["home"])
    }, 2000);
  }
  public serviceupcheck(){
    this.signupservice.test().subscribe(
      data=>{
        this.workingStatus=data;
        console.log(this.workingStatus);
        this.gett();
      }
    )
  }
  
  public gett(){
    if(this.workingStatus=="working"){
      this.signupservice.enroll(this.usermodel).subscribe(
        data => console.log('Success', data)
      )
    }
  }
  toggleform(){
    if(localStorage.getItem('email')!==null){
      window.alert("Already Signed in ")
      this.router.navigate(["home"])
    }
    else{
      this.router.navigate(["signin"])
    }
    this.signupform = !this.signupform
  }
}


