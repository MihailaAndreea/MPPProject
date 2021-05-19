import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {filter, switchMap, tap} from "rxjs/operators";
import {Location} from "@angular/common";
import {Employee} from "../shared/employee.model";
import {EmployeeService} from "../shared/employee.service";


@Component({
  moduleId: module.id,
  selector: 'app-employee-filter',
  templateUrl: './employee-filter.component.html',
  styleUrls: ['./employee-filter.component.css'],
})
export class EmployeeFilterComponent implements OnInit {
  @Input() input: string;
  errorMessage: string;
  employees: Array<Employee>;
  filteredEmployees: Array<Employee>

  constructor(private employeeService: EmployeeService,
              private route: ActivatedRoute,
              private location: Location,
              private router: Router) {
  }

  ngOnInit(): void {
    this.set();
    // this.filterChanged(this.input);
    }
    set():void{
      this.route.params
        .subscribe(params => {
        this.input = params['id']
          .tap((response) => console.log(response));
      });
      // this.employeeService.gtEmployees()
      //   .subscribe((fetchedEmployees) => {
      //     this.employees = fetchedEmployees;
      //     this.filteredEmployees = fetchedEmployees;
      //   })
    }


  filterChanged(value: string){
  if (value === "All") {
  this.filteredEmployees = this.employees;
} else {
  this.filteredEmployees =
    this.employees.filter((value1) => {value1.name.includes(this.input)});
  }
  }

  goBack(): void {
    this.location.back();
  }


}
