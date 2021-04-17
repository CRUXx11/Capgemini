import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hfooter',
  templateUrl: './hfooter.component.html',
  styleUrls: ['./hfooter.component.css']
})
export class HfooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public changetoadmin(){
    localStorage.setItem('admin',"admin");
    window.open("http://localhost:9091/admin/test")
  }

}
