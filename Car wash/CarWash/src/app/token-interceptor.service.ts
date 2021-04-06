// import { Injectable,Injector } from '@angular/core';
// import { HttpInterceptor } from '@angular/common/http';
// import { SigninService } from './signin/signin.service';
// @Injectable({
//   providedIn: 'root'
// })
// export class TokenInterceptorService implements HttpInterceptor{

//   constructor(private injector:Injector) { }

//   intercept(req, next) {
//     let signinService=this.injector.get(SigninService)
//     let tokenizedReq = req.clone({
//       setHeaders: {
//         Authorization:`Bearer ${signinService.generatetoken}`
//       }
//     })
//     return next.handle(tokenizedReq)
//   }
// }
