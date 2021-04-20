import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../signup/customer';
import { PaymentService } from './payment.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  
  name=localStorage.getItem('name');
  email=localStorage.getItem('email');
  contact=localStorage.getItem('contact');
  paymentdetails=false;
  paymentfetch:boolean;
 payment ={
paymentId:""
}
stat=""
  signinstatus:boolean;
  constructor(private router:Router,private paymentservice:PaymentService) { }

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
 togglepayment(){
   this.paymentdetails=!this.paymentdetails;
this.paymentservice.test(this.payment.paymentId).subscribe(
  data=>{
    localStorage.setItem('payment',JSON.stringify(data));
    this.paymentfetch=true
  }
)
this.getpaymentstatus();
  }
  getpaymentstatus(){
    this.stat=JSON.parse(localStorage.getItem('payment'));
    console.log(this.stat);   

  }

}
