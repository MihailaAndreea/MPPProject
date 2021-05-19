import {Component, OnInit} from '@angular/core';
import {ProductionLot} from "../shared/production.model";
import {ProductionLotService} from "../shared/production.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {switchMap, tap} from "rxjs/operators";
import {Location} from "@angular/common";


@Component({
  moduleId: module.id,
  selector: 'app-production-sort',
  templateUrl: './production-sort.html',
  styleUrls: ['./production-sort.css'],
})
export class ProductionSort implements OnInit {
  errorMessage: string;
  productionLots: Array<ProductionLot>;
  selectedProductionLot: ProductionLot;

  constructor(private productionLotService: ProductionLotService,
              private route: ActivatedRoute,
              private location: Location,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(
        switchMap((params: Params) => this.productionLotService.findByOrderByChocolateIDAsc()),
        tap((response) => console.log(response))
      )
      .subscribe(productionLots => this.productionLots = productionLots);
  }

  onSelect(productionLot: ProductionLot): void {
    this.selectedProductionLot = productionLot;
  }

  goBack(): void {
    this.location.back();
  }

  gotoDetail(): void {
    this.router.navigate(['/productionLot/detail', this.selectedProductionLot.id]);
  }

}
