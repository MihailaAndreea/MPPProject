import {Component, Input, OnInit} from '@angular/core';
import {ProductionLotService} from "../shared/production.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';
import {ProductionLot} from "../shared/production.model";

import {switchMap} from "rxjs/operators";


@Component({
  selector: 'app-production-detail',
  templateUrl: './production-detail.component.html',
  styleUrls: ['./production-detail.component.css'],
})

export class ProductionLotDetailComponent implements OnInit {

  @Input() productionLot: ProductionLot;

  constructor(private productionLotService: ProductionLotService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.productionLotService.getProductionLot(+params['id'])))
      .subscribe(productionLot => this.productionLot = productionLot);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.productionLotService.update(this.productionLot)
      .subscribe(_ => this.goBack());
  }
}
