import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SigninService {
   constructor(private http:HttpClient) { }

  public generatetoken(user) {
    return this.http.post('http://localhost:9092/customers/authenticate', user, { responseType: 'text' as 'json' })
      .pipe(catchError(this.errorHandler));     
  }
  public test(){
    return this.http.get('http://localhost:9092/customers/test',{ responseType: 'text' as 'json' })
   .pipe(catchError(this.errorHandler))
  }
  public getlogin(user){
    return this.http.post('http://localhost:9092/customers/get', user)
  }
  // public welcome(token) {
  //   let tokenstr = "Bearer " + token;
  //   const header =  new HttpHeaders().set("Authorization", tokenstr)
  //   return this.http.get('http://localhost:9092/getAll',{headers:header,responseType:'text' as 'json'})
  // }

  
  errorHandler(error: HttpErrorResponse) {
    window.alert(error);
    return throwError(error);
  }
}
