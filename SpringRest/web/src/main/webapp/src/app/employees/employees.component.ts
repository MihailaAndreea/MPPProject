import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ProductionLotService} from "../productions/shared/production.service";
import {Router} from "@angular/router";
import {ProductionLot} from "../productions/shared/production.model";
import {AbstractControl, NgForm, ValidationErrors} from "@angular/forms";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  @Input() id:string;
  @Input() name:string;
  @ViewChild('idForm') idForm : NgForm;

  constructor(private router: Router) {
  }


  notANumber(control: string): ValidationErrors | null {
    if (typeof +control === "number" && !isNaN(+control)) return null;
    return { notANumber: "The value is not a number"};
  }


  gotoFilterByName(name: string): void {
    this.id = name;
    console.log("to go:", this.id);
    this.router.navigate(['/filterByName', this.id]);
  }


  ngOnInit(): void {
  }

}
