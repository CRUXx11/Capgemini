import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

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
  refresh(){
    window.location.reload();
  }

}
