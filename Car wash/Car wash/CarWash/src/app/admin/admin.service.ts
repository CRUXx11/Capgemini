import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders,HttpParams} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }
  public enroll(customer) {
    return this.http.post('http://localhost:9091/admin/create',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }

  public delete(email) {
    let body=new HttpParams();
         body=body.set('firstName',email);
    return this.http.post('http://localhost:9091/admin/delete',body,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }

  public update(customer) {
    return this.http.post('http://localhost:9091/admin/update',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }
  public test(){
    return this.http.get('http://localhost:9091/admin/test',{ responseType: 'text' as 'json' })
  }
  public getlogin(){
    return this.http.get('http://localhost:9091/admin/getAll')
  }


  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
