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
    return this.http.post('http://localhost:9090/authenticate', user, { responseType: 'text' as 'json' })
      .pipe(catchError(this.errorHandler));
         
  }
  
  // public welcome(token) {
  //   let tokenstr = "Bearer " + token;
  //   const headers = new HttpHeaders().set("Authorization", tokenstr)
  //   console.log("welcome "+tokenstr)
  //   return this.http.get('http://localhost:8080/',{headers,responseType:'text' as 'json'})
  // }

  
  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
