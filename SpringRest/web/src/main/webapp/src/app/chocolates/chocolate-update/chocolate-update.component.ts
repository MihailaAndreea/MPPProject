import {Component, Input, OnInit} from '@angular/core';
import {ChocolateService} from "../shared/chocolate.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';
import {Chocolate} from "../shared/chocolate.model";

import {switchMap, tap} from "rxjs/operators";
import {Observable} from "rxjs";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";


@Component({
  selector: 'app-chocolate-update',
  templateUrl: './chocolate-update.component.html',
  styleUrls: ['./chocolate-update.css'],
})

export class ChocolateUpdateComponent implements OnInit {

  @Input() chocolate: Chocolate;
  chocolateForm: FormGroup;

  constructor(private chocolateService: ChocolateService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  notANumber(control: AbstractControl): ValidationErrors | null {
    if (typeof +control === "number" && !isNaN(+control)) return null;
    return { notANumber: "The value is not a number"};
  }

  ngOnInit(): void {
    this.route.params
      .pipe(
        switchMap((params: Params) => this.chocolateService.getChocolate(+params['id'])),
        tap((response) => console.log(response))
      )
          .subscribe(chocolate => this.chocolate = chocolate);
    this.chocolateForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      ingredients: new FormControl(null, Validators.required),
      weight: new FormControl(0, Validators.required),
      price: new FormControl(0, Validators.required)
    });
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.chocolate.name = this.chocolateForm.value.name;
    this.chocolate.ingredients = this.chocolateForm.value.ingredients;
    this.chocolate.weight = +this.chocolateForm.value.weight;
    this.chocolate.price = +this.chocolateForm.value.price;
    console.log("updated to:", this.chocolate);
    this.chocolateService.update(this.chocolate)
      .subscribe(_ => this.goBack());
  }
}
