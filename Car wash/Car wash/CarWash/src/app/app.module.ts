import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule, routingcomponents } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule,HTTP_INTERCEPTORS} from '@angular/common/http'
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule } from '@angular/material/icon';
import {MatDialogModule } from '@angular/material/dialog';
import {MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule } from '@angular/material/input';
import {MatButtonModule } from '@angular/material/button';
import {MatTableModule } from '@angular/material/table';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import { HfooterComponent } from './hfooter/hfooter.component';
import { HeaderComponent } from './header/header.component';

// import { TokenInterceptorService } from './token-interceptor.service';
@NgModule({
  declarations: [
    AppComponent,
    routingcomponents,
    DialogBoxComponent,
    HfooterComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatTableModule,
    MatDialogModule,MatFormFieldModule,MatInputModule,MatButtonModule,
  ],
  providers: [
    // {
    // provide: HTTP_INTERCEPTORS,
    // useClass:TokenInterceptorService
    //}
  ],
  bootstrap:[AppComponent]
})
export class AppModule{}