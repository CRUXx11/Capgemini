import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from './order.service';
import{Order} from './order';
@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {

  constructor(private router:Router,private orderservice:OrderService) { }

  ngOnInit(): void {
  }
  
  usermodel:Order=new Order("","","","")

  public checklogin(){
    if(localStorage.getItem('email')===null){
      this.router.navigate(["signup"])
    }
    else{
      this.router.navigate(["profile"]);
    }
  }

  public Book(){
    this.orderservice.booknow(this.usermodel).subscribe(
      data=>{
        console.log(data);
      }
    )
  }
}
