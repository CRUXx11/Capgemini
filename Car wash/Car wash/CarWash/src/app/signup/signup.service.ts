import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Customer} from './customer';

export const HTTP_OPTIONS={
  headers:new HttpHeaders({
    'Content-Type':'application/json',
    'Access-Control-Allow-Origin':"*",
    'Access-Control-Allow-Headers':"*"
  })
}

@Injectable({
  providedIn: 'root'
})


export class SignupService {
  
  constructor(private http:HttpClient) { }

  public enroll(customer) {
    return this.http.post('http://localhost:9092/customers/create',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }
  public test(){
    return this.http.get('http://localhost:9089/customers/test',{ responseType: 'text' as 'json' })
  }

  
  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
