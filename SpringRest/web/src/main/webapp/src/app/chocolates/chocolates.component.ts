import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ProductionLotService} from "../productions/shared/production.service";
import {Router} from "@angular/router";
import {ProductionLot} from "../productions/shared/production.model";
import {AbstractControl, NgForm, ValidationErrors} from "@angular/forms";

@Component({
  selector: 'app-chocolates',
  templateUrl: './chocolates.component.html',
  styleUrls: ['./chocolates.component.css']
})
export class ChocolatesComponent implements OnInit {

  @Input() id:number;
  @ViewChild('idForm') idForm : NgForm;

  constructor(private router: Router) {
  }

  gotoAdd(): void {
    console.log("to go:", this.router);
    this.router.navigate(['/chocolate-new']);
  }

  notANumber(control: string): ValidationErrors | null {
    if (typeof +control === "number" && !isNaN(+control)) return null;
    return { notANumber: "The value is not a number"};
  }

  gotoUpdate(id:string): void {
      console.log("number!", id);
      this.id = +id;
      console.log("to go:", this.id);
      this.router.navigate(['/chocolate-update', this.id]);
      console.log("not a number!", id);
  }

  gotoDelete(id:string): void {
    this.id = +id;
    console.log("to go:", this.id);
    this.router.navigate(['/chocolate-delete', this.id]);
  }

  ngOnInit(): void {
  }

}
