import {Component, OnInit} from '@angular/core';
import {Chocolate} from "../shared/chocolate.model";
import {ChocolateService} from "../shared/chocolate.service";

@Component({
  selector: 'app-chocolate-list',
  templateUrl: './chocolate-list.component.html',
  styleUrls: ['./chocolate-list.component.css']
})
export class ChocolateListComponent implements OnInit {
  chocolates: Chocolate[];

  constructor(private chocolateService: ChocolateService) {
  }

  ngOnInit(): void {
    this.chocolateService.getChocolates()
      .subscribe(chocolates => this.chocolates = chocolates);


  }

}
