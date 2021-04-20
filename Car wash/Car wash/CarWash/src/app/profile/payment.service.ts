import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http:HttpClient) { }

  public test(id){
    return this.http.get('http://localhost:8080/order/orderId/'+id)
    .pipe(catchError(this.errorHandler)) 
    window.location.reload()
  }

  errorHandler(error: HttpErrorResponse) {
    window.alert("Server Error:Please try later");
    window.location.reload()
    return throwError(error);
  }

}
