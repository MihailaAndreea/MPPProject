import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ProductionLotService} from "../productions/shared/production.service";
import {Router} from "@angular/router";
import {ProductionLot} from "../productions/shared/production.model";
import {AbstractControl, NgForm, ValidationErrors} from "@angular/forms";

@Component({
  selector: 'app-registries',
  templateUrl: './registries.component.html',
  styleUrls: ['./registries.component.css']
})
export class RegistriesComponent implements OnInit {

  @Input() id:number;
  @ViewChild('idForm') idForm : NgForm;

  constructor(private router: Router) {
  }


  notANumber(control: string): ValidationErrors | null {
    if (typeof +control === "number" && !isNaN(+control)) return null;
    return { notANumber: "The value is not a number"};
  }


  ngOnInit(): void {
  }

}
