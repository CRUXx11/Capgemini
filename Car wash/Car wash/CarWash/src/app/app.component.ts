import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router:Router) { }
  ngOnInit(): void {
this.currpage=localStorage.getItem('admin');
  }
  currpage:any;
  title = 'CarWash';
  onActivate(event) {
    window.scroll(0,0);
    //or document.body.scrollTop = 0;
    //or document.querySelector('body').scrollTo(0,0) 
}
scrollToTop() {
  window.scrollTo({top: 0, behavior: 'smooth'});
  
  }
public adminrender(){
localStorage.setItem('admin',"admin");
window.open("http://localhost:9091/admin/test");
this.router.navigate(["home"]);
}

}
