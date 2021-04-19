import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
// import {Razorpay} from 'razorpay';
@Injectable({
  providedIn: 'root'
})

export class OrderService {
  payment={
    "id": "",
    "entity": "",
    "amount": "",
    "currency": "",
    "status": "",
    "order_id": "",
    "invoice_id": null,
    "international": false,
    "method": "",
    "amount_refunded": 0,
    "refund_status": null,
    "captured": true,
    "description": null,
    "card_id": null,
    "bank": null,
    "wallet": null,
    "vpa": "",
    "email": "",
    "contact": "",
    "notes": {
        "email": "",
        "phone": "",
        "car_number": "",
        "date": ""
    },
    "fee": null,
    "tax": null,
    "error_code": null,
    "error_description": null,
    "error_source": null,
    "error_step": null,
    "error_reason": null,
    "acquirer_data": {
        "rrn": "",
        "upi_transaction_id": ""
    },
    "created_at": null
}
//  instance = new Razorpay({
//     key_id: 'rzp_test_oVLnRK0PRIAX1X',
//     key_secret: 'pSrLpFSI63js3oaI3Lfik4hP'
//   })

  // public allpayments(){
  //   console.log(this.instance.payments.all( {
  //     from: '2020-04-15',
  //     to: '2020-04-30',
  //   },
  //   (error, response) => {
  //     if (error) {
  //       // handle error
  //     } else {
  //       // handle success
  //     }
  //   }));
  // }

  constructor(private http:HttpClient) { }

  public booknow(customer) {
    return this.http.post('http://localhost:9092/order/booknow',customer,{responseType:'text' as 'json'})
         .pipe(catchError(this.errorHandler))    
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
