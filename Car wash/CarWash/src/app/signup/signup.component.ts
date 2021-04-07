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
  
  constructor(private signupservice:SignupService,private router:Router) { }

  ngOnInit(): void {
  }
  
  public onsubmit() {
    this.submitted = true;
    this.signupservice.enroll(this.usermodel).subscribe(
      data => console.log('Success', data)
    )
    setTimeout(() => {
      this.router.navigate(["home"])
    }, 2000);
  }
  toggleform(){
    this.signupform = !this.signupform
  }
}


