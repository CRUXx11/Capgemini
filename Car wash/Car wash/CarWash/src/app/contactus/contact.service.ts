import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http:HttpClient) { }
  public enroll(customer) {
    return this.http.post('http://localhost:9092/customers/create',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }



  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
