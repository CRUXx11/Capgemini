import { Component, ViewChild,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from '../dialog-box/dialog-box.component';
import {AdminService} from './admin.service';
import { Updatecustomer } from './updatecustomer';
import { Customer } from '../signup/customer';
export interface UsersData {
  name: string;
  email:string;
  contact:number
}
const ELEMENT_DATA: UsersData[] = [
  
];
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  workingStatus:any;
  displayedColumns: string[] = ['name','password', 'email', 'contact','action'];
  dataSource :any;
  usermodel:Customer=new Customer("","","","")

  ngOnInit(): void {

  }

  

  @ViewChild(MatTable,{static:true}) table: MatTable<any>;

  constructor(private router:Router,public dialog: MatDialog,private adminservice:AdminService) {
  
  }

  public gett(){
      this.adminservice.getlogin().subscribe(
        data => this.dataSource=data
      )
  
  }

  openDialog(action,obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '250px',
      data:obj
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result.event == 'Add'){
        console.log(result.data);
      }else if(result.event == 'Update'){
        this.updateRowData(result.data);
      }else if(result.event == 'Delete'){
        this.deleteRowData(result.data);
      }
    });
  }

  addRowData(row_obj){
     this.dataSource.push({
      name:row_obj.name,
      email:row_obj.email,
      contact:row_obj.contact
    });
    this.table.renderRows();
    
    
  }
  updateRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      if(value.email == row_obj.email){
        this.usermodel.Name=row_obj.name;
        this.usermodel.password=row_obj.password;
        this.usermodel.contact=row_obj.contact;
        this.usermodel.email=row_obj.email;
        value.name = row_obj.name;
        value.contact=row_obj.contact;
        console.log(this.usermodel);
      }
      this.adminservice.update(this.usermodel).subscribe(
        data=>{
          console.log(data);
        }
      )
      return true;
    });
  }
  deleteRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      return value.email != row_obj.email;
    });
  }

  public notadmin(){
    localStorage.setItem('admin',"notadmin");
    window.open("http://localhost:4200")
  }
}
