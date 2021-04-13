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
  workingStatus:any;
  signupform = true;
  usermodel: Signinuser = new Signinuser("","");
  constructor(private signinservice:SigninService,private router:Router) { }

  ngOnInit(): void {
  }

  toggleform(){
    this.signupform = !this.signupform
  }

  public onsubmit() {
    this.submitted = true;
    this.serviceupcheck();
  }
  public serviceupcheck(){
      this.signinservice.test().subscribe(
        data=>{
          this.workingStatus=data;
          console.log(this.workingStatus);
          this.gett();
        }
      )
    }
  public gett(){
    if(this.workingStatus=="working"){
      this.signinservice.generatetoken(this.usermodel).subscribe(
        data => {
          this.jwttoken = data
          localStorage.setItem('token', this.jwttoken)
          console.log(this.jwttoken)
          this.finalconfirmation();
        }
      );
    }
  }
  public finalconfirmation(){
    if(this.jwttoken.slice(13,this.jwttoken.length-2)=="Invalid Username or Password"){
      window.alert("Invalid username or Password");
      window.location.reload();
    }
    else{
      window.alert("Signin Successful");
      setTimeout(() => {
        this.router.navigate(["home"])
      }, 2000);
    }
  }

  // public getuserdetails(token) {
  //   let resp= this.signinservice.welcome(token).subscribe(
  //     data => {
  //       this.resp = data
  //       console.log(this.resp)
  //     });
    
  // }

  
}
