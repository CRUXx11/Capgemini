import { Component, OnInit } from '@angular/core';
import { Signinuser } from './signinuser';
import {SigninService} from './signin.service';
import { Router } from '@angular/router';
import { HttpInterceptor } from '@angular/common/http';
import { UsernameServiceService } from '../username-service.service';

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
  username:string;
  workingStatus:any;
  signupform = true;
  usermodel: Signinuser = new Signinuser("","");
  constructor(private signinservice:SigninService,private router:Router,private usernameservice:UsernameServiceService) { }
 user:any;
  ngOnInit(): void {

  }

  toggleform(){
    this.signupform = !this.signupform
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
  }
  public serviceupcheck(){
      this.signinservice.test().subscribe(
        data=>{
          this.workingStatus=data;
          if(this.workingStatus=="Customer Service is taking too long to respond or is down.Please try again later"){
            window.alert("Service is down.Please try after sometime");
          }
          else{
          console.log(this.workingStatus);
          this.gett();}
        }
      )
    }

public gett(){
  if(this.workingStatus=="working"){
    this.signinservice.generatetoken(this.usermodel).subscribe(
      data => {
        this.jwttoken = data
        localStorage.setItem('token',this.jwttoken.slice(13,this.jwttoken.length-2))
        console.log(this.jwttoken.slice(13,this.jwttoken.length-2))
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
  localStorage.setItem('email',this.usermodel.email);
    window.alert("Signin Successful");
    // this.getuserdetails(this.jwttoken.slice(13,this.jwttoken.length-2))
    this.getlogindetails();
    setTimeout(() => {
      this.router.navigate(["home"])
    }, 2000);
  }
}
 
public getlogindetails(){
  this.signinservice.getlogin(this.usermodel).subscribe(
    data=>{
      this.workingStatus=data;
      console.log(this.workingStatus);
      localStorage.setItem('name',this.workingStatus.name)
      localStorage.setItem('contact',this.workingStatus.contact)
    }
  )
}
//   public getuserdetails(token) {
//     let resp= this.signinservice.welcome(token).subscribe(
//       data => {
//      this.user=data;
//      console.log(data);
//       });
//   }

  
}
