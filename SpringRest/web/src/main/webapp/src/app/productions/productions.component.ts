import {Component, Input, ViewChild} from "@angular/core";
import {ProductionLotService} from "./shared/production.service";
import {Router} from "@angular/router";
import {NgForm, ValidationErrors} from "@angular/forms";

@Component({
  moduleId: module.id,
  selector: 'app-production',
  templateUrl: './productions.component.html',
  styleUrls: ['./productions.component.css'],
})
export class ProductionLotsComponent {
  @Input() id:number;
  @ViewChild('idForm') idForm : NgForm;

  constructor(private router: Router) {
  }

  notANumber(control: string): ValidationErrors | null {
    if (typeof +control === "number" && !isNaN(+control)) return null;
    return { notANumber: "The value is not a number"};
  }


  gotoFilterByChocoID(id: string): void {
    this.id = +id;
    console.log("to go:", this.id);
    this.router.navigate(['/filterByChocoId', this.id]);
  }

  goToSort(): void{
    this.router.navigate(['/sortedProductions']);
  }
}
