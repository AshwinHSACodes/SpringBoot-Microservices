import { Component } from '@angular/core';
import { EmployeeServiceService } from '../../services/employee-service.service';
import { Employee } from '../../Model/Employee.model';


@Component({
  selector: 'app-viewemployees',
  templateUrl: './viewemployees.component.html',
  styleUrl: './viewemployees.component.css'
})
export class ViewemployeesComponent {

  employeesList: any;

  displayedColumns: string[] = [];

  constructor(private employeeService: EmployeeServiceService){
    employeeService.getAllEmployees().subscribe(res=>this.employeesList=res);
    displayedColumns: ['position', 'FirstName', 'LastName', 'Email', 'Address'];
    console.log(this.employeesList);

  }
}
