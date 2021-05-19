import {Component, Input, OnInit} from '@angular/core';
import {ChocolateService} from "../shared/chocolate.service";
import {Chocolate} from "../shared/chocolate.model";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap, tap} from "rxjs/operators";

@Component({
  selector: 'app-chocolate-delete',
  templateUrl: './chocolate-delete.component.html',
  styleUrls: ['./chocolate-delete.component.css']
})
export class ChocolateDeleteComponent implements OnInit {

  @Input() chocolate : Chocolate;

  constructor(private chocolateService: ChocolateService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(
        switchMap((params: Params) => this.chocolateService.getChocolate(+params['id'])),
        tap((response) => console.log(response))
      )
      .subscribe(chocolate => this.chocolate = chocolate);
  }

  delete() {
    console.log("to delete:", this.chocolate.id);

    this.chocolateService.delete(this.chocolate.id)
      .subscribe(chocolate => console.log("deleted chocolate: ", chocolate));
  }

  goBack(): void {
    this.location.back();
  }
}
