import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactService } from './contact.service';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent implements OnInit {

  constructor(private router:Router,private contactservice:ContactService) { }

    value={
      name:"",
      email:"",
      subject:"",
      message:""
    }

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
  onSubmit(){

  }

}
