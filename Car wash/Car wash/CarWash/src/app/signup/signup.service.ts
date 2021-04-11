import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Customer} from './customer';
@Injectable({
  providedIn: 'root'
})
export class SignupService {
  
  constructor(private http:HttpClient) { }

  public enroll(customer) {
    return this.http.post('http://localhost:9089/customers/create',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))
         
  }
  
  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
