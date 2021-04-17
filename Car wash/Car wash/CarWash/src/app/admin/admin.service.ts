import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }
  public update(customer) {
    return this.http.post('http://localhost:9091/admin/update',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }
  public test(){
    return this.http.get('http://localhost:9092/admin/test',{ responseType: 'text' as 'json' })
  }
  public getlogin(){
    return this.http.get('http://localhost:9091/admin/getAll')
  }


  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
