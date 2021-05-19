import {Component, OnInit} from '@angular/core';
import {ProductionLot} from "../shared/production.model";
import {ProductionLotService} from "../shared/production.service";
import {Router} from "@angular/router";


@Component({
  moduleId: module.id,
  selector: 'app-production-list',
  templateUrl: './production-list.component.html',
  styleUrls: ['./production-list.component.css'],
})
export class ProductionLotListComponent implements OnInit {
  errorMessage: string;
  productionLots: Array<ProductionLot>;
  selectedProductionLot: ProductionLot;

  constructor(private productionLotService: ProductionLotService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getProductionLot();
  }

  getProductionLot() {
    this.productionLotService.getProductionLots()
      .subscribe(
        productionLots => this.productionLots = productionLots,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(productionLot: ProductionLot): void {
    this.selectedProductionLot = productionLot;
  }

  gotoDetail(): void {
    this.router.navigate(['/productionLot/detail', this.selectedProductionLot.id]);
  }

}
