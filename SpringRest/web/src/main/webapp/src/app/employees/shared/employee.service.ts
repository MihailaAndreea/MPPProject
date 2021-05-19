import {Injectable} from '@angular/core';

import {HttpClient, HttpEvent} from "@angular/common/http";


import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";
import {Employee} from "./employee.model";


@Injectable()
export class EmployeeService {
  private employeeUrl = 'http://localhost:8080/test/api/employees';

  constructor(private httpClient: HttpClient) {
  }

  getEmployees(): Observable<Employee[]> {
    return this.httpClient
      .get<Record<'employeeDtoSet', Array<Employee>>>(this.employeeUrl)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.employeeDtoSet),
      );
  }


  getEmployee(id: number): Observable<Employee> {
    return this.getEmployees()
      .pipe(
        map(employees => employees.find(employee => employee.id === id)),
        tap((response) => console.log(response))
      );
  }

}
