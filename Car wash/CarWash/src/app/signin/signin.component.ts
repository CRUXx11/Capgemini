import { Component, OnInit } from '@angular/core';
import { Signinuser } from './signinuser';
import {SigninService} from './signin.service';
import { Router } from '@angular/router';
import { HttpInterceptor } from '@angular/common/http';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  errmsg = '';
  submitted = false;
  jwttoken: any;
  resp: any;
  usermodel: Signinuser = new Signinuser("","");
  constructor(private signinservice:SigninService,private router:Router) { }

  ngOnInit(): void {
  }

  

  public onsubmit() {
    this.submitted = true;
    this.signinservice.generatetoken(this.usermodel).subscribe(
      data => {
        this.jwttoken = data
        localStorage.setItem('token', this.jwttoken)
        console.log(this.jwttoken)
      }
    );
  }
  // public getuserdetails(token) {
  //   let resp= this.signinservice.welcome(token).subscribe(
  //     data => {
  //       this.resp = data
  //       console.log(this.resp)
  //     });
    
  // }

  
}
