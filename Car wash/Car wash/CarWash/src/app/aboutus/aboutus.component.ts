import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['./aboutus.component.css']
})
export class AboutusComponent implements OnInit {

  constructor(private router:Router) {
    
   }
   dataRefresher: any;
  ngOnInit(): void {

  }

  refresh(){
    window.location.reload();
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
