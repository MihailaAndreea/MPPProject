import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../shared/employee.model";
import {EmployeeService} from "../shared/employee.service";
import {tap} from "rxjs/operators";

type SortDirection = 'asc' | 'desc';

@Component({
  moduleId: module.id,
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  @Input() input:string;
  errorMessage: string;
  employees: Array<Employee>;
  employeesFiltered: Array<Employee>;
  filtered: boolean = false;

  sortDirections: string;

  constructor(private employeeService: EmployeeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getEmployee();
  }

  getEmployee() {
    this.employeeService.getEmployees()
      .subscribe(
        employees => this.employeesFiltered = employees,
        error => this.errorMessage = <any>error,
        () => this.employees = this.employeesFiltered
      );
  }

  filter(){
    this.employeesFiltered = this.employees.filter((value) => value.name.includes(this.input));
    this.filtered = true;
  }

  sort(){
    console.log("am intrat");
    this.employees.sort((e1: Employee, e2: Employee) => {
      console.log("emp1:",e1.name,"| emp2:",e2.name,"sort value:",e1.name.localeCompare(e2.name));
      if(e1.name < e2.name)
        console.log(e1.name);
      else console.log(e2.name)
      return e1.name.localeCompare(e2.name, 'en', {numeric: true});
    })
  }

}
