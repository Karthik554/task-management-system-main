import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

listOfTasks: any = [];

  constructor(private service: EmployeeService, 
    private snackbar : MatSnackBar  
  ){
    this.getTasks();
   }

  getTasks(){
    this.service.getEmployeeTaskById().subscribe((res)=>{
        console.log(res);
        this.listOfTasks = res;
    })
  }

  updateStatus(id:number, status:string){
    this.service.updateStatus(id, status).subscribe((res)=>{
      if(res.id != null) {
        this.snackbar.open("Task status update Successfully", "Close", { duration: 5000 });
        this.getTasks()
      }else{
        this.snackbar.open("Getting error while updating task", "Close", { duration: 5000 });
      }
    })
   }
}
