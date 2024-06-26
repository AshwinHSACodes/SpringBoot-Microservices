import { Component } from '@angular/core';
import { Employee } from '../../Model/Employee.model';
import { FormControl, FormGroup } from '@angular/forms';
import { EmployeeServiceService } from '../../services/employee-service.service';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrl: './addemployee.component.css'
})
export class AddemployeeComponent {


  saveEmplyoeeFrom = new FormGroup({
    empid: new FormControl('dummyvalue'),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    emailid: new FormControl(''),
    address: new FormControl(''),
    mobileno: new FormControl(''),
    userName: new FormControl(''),
    passWord: new FormControl('')
  })

  employee = new Employee();
  temp! : any;

  constructor(private employeeSerivce: EmployeeServiceService){
    //this.employeeSerivce.getAllEmployees().subscribe(res=>console.log(JSON.stringify(res)));
    //this.employeeSerivce.getEmployeeById(1).subscribe(res=>console.log(JSON.stringify(res)));
    // this.employeeSerivce.saveEmployee(this.employee).subscribe(res=>{
    //   console.log("EmployeeSaved : " + JSON.stringify(res));
    // }); 
    //this.saveEmployee();
  }

  saveEmployee(){

    // this.employee.firstName = this.saveEmplyoeeFrom.get("firstName")?.value;
    // this.employee.lastName = this.saveEmplyoeeFrom.get("lastName")?.value;
    // this.employee.emailid = this.saveEmplyoeeFrom.get("emailid")?.value;
    // this.employee.address = this.saveEmplyoeeFrom.get("address")?.value;
    // this.employee.mobileno = this.saveEmplyoeeFrom.get("mobileno")?.value;
    // this.employee.userName = this.saveEmplyoeeFrom.get("userName")?.value;
    // this.employee.passWord = this.saveEmplyoeeFrom.get("passWord")?.value;

    console.log("this.saveEmplyoeeFrom.value.firstName : " + this.saveEmplyoeeFrom.value.firstName);

    this.employee.firstName = this.saveEmplyoeeFrom.value.firstName;
    this.employee.lastName = "firstName";
    this.employee.emailid = "firstName";
    this.employee.address = "firstName";
    this.employee.mobileno = "firstName";
    this.employee.userName = "firstName";
    this.employee.passWord = "firstName";

    console.log("calling saveemployee method");
    console.log("this.employee.firstName : " + this.employee.firstName);
    // this.employeeSerivce.saveEmployee(this.employee).subscribe(res=>{
    //                                                                   //console.log("EmployeeSaved : " + JSON.stringify(res));
    //                                                                 });

     this.employeeSerivce.sayHelloPostMethodCall(this.employee).subscribe(res=>console.log(res));

  }

  getAllEmployees(){
    
    this.employeeSerivce.getAllEmployees().subscribe(res=>console.log(JSON.stringify(res)));
  }

}
