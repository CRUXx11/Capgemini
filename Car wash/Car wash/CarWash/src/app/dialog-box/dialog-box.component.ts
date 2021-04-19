import { Component,Inject,Optional, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AdminService } from '../admin/admin.service';

export interface UsersData {
  name: string;
  password:string;
  email:string;
  contact:string;
}
@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent implements OnInit {

  action:string;
  local_data:any;

  constructor(private adminservice:AdminService,
    public dialogRef: MatDialogRef<DialogBoxComponent>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: UsersData) {
    console.log(data);
    this.local_data = {...data};
    this.action = this.local_data.action;
  }

  doAction(){
    this.dialogRef.close({event:this.action,data:this.local_data});
   if(this.action=="Add"){
     this.adminservice.enroll(this.local_data).subscribe(
       resp=>{
         console.log(resp);
       }
     )
   }
   
  }

  closeDialog(){
    this.dialogRef.close({event:'Cancel'});
  }

  ngOnInit(): void {
  }

}
