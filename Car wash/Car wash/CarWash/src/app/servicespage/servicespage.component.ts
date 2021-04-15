import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsernameServiceService } from '../username-service.service';

@Component({
  selector: 'app-servicespage',
  templateUrl: './servicespage.component.html',
  styleUrls: ['./servicespage.component.css']
})
export class ServicespageComponent implements OnInit {

  username=localStorage.getItem('email');
  constructor(private usernameservice:UsernameServiceService,private router:Router) { }

  ngOnInit(): void {
  // this.usernameservice.username$.subscribe(
  //   data=>{
  //     this.username=data;
  //   }
  //   )
  }
  public checklogin(){
    if(localStorage.getItem('email')===null){
      this.router.navigate(["signup"])
    }
    else{
      this.router.navigate(["profile"]);
    }
  }

}
