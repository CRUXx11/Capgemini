import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsernameServiceService {

  private username=new Subject<string>();
  username$=this.username.asObservable();
  constructor() { }
  getusername(msg:string){
    this.username.next(msg);
  }
}
