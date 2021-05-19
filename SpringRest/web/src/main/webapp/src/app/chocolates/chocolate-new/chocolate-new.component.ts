import {Component, OnInit, ViewChild} from '@angular/core';
import {ChocolateService} from "../shared/chocolate.service";
import {Chocolate} from "../shared/chocolate.model";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {AbstractControl, NgForm, ValidationErrors, ValidatorFn} from "@angular/forms";
import {isInteger} from "@ng-bootstrap/ng-bootstrap/util/util";

@Component({
  selector: 'app-chocolate-new',
  templateUrl: './chocolate-new.component.html',
  styleUrls: ['./chocolate-new.component.css']
})
export class ChocolateNewComponent implements OnInit {

  @ViewChild('chocolateForm') chocolateForm : NgForm;
  model = new Chocolate();
  submitted = false;

  constructor(private chocolateService: ChocolateService,
              private route: ActivatedRoute,
              private location: Location) {
  }

   notANumber(control: AbstractControl): ValidationErrors | null {
  if (typeof +control === "number" && !isNaN(+control)) return null;
  return { notANumber: "The value is not a number"};
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.model.name = this.chocolateForm.value.name;
    this.model.ingredients = this.chocolateForm.value.ingredients;
    if(this.notANumber(this.chocolateForm.value.weight) == null && this.notANumber(this.chocolateForm.value.price) == null)
    {
      console.log("number!", +this.chocolateForm.value.weight, this.model.price = +this.chocolateForm.value.price);
      this.model.weight = +this.chocolateForm.value.weight;
      this.model.price = +this.chocolateForm.value.price;
    }
    else {
      console.log("not a number!", this.chocolateForm.value.weight);
    }

  }

  saveChocolate() {
    console.log("to save:", this.model);

    this.chocolateService.saveChocolate(this.model)
      .subscribe(chocolate => console.log("saved chocolate: ", chocolate));
    this.goBack();

  }
  goBack(): void {
    this.location.back();
  }
}
