import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../Model/Employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private saveEmployeeUrl = "http://localhost:8001/employee/saveEmployee";
  private getAllEmployeesUrl = "http://localhost:8001/employee/getAllEmployees";
  private getEmployeesByIdUrl = "http://localhost:8001/employee/getEmployeeById/2";
  private sayHelloPostMethodCallUrl = "http://localhost:8001/employee/hello";

  constructor(private httpClient: HttpClient) { }

  saveEmployee(employee: Employee): Observable<Object> {
    //console.log("From saveEmployee method ......" + JSON.stringify(employee));
    return this.httpClient.post(`${this.saveEmployeeUrl}`, employee);
  }

  getAllEmployees(): Observable<Object> {
    console.log("From getAllEmployees method ......");
    return this.httpClient.get(`${this.getAllEmployeesUrl}`);
  }

  sayHelloPostMethodCall(employee: Employee): Observable<Object> {
    console.log("From getAllEmployees method ......");
    
    return this.httpClient.post(`${this.sayHelloPostMethodCallUrl}`, employee);
  }

  getEmployeeById(id: number): Observable<Object> {
    console.log("From getEmployeeById method ......" + id);
    return this.httpClient.get(`${this.getEmployeesByIdUrl}`);
  }
}
