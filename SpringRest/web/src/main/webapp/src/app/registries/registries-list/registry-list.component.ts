import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Registry} from "../shared/registry.model";
import {RegistryService} from "../shared/registry.service";


@Component({
  moduleId: module.id,
  selector: 'app-registry-list',
  templateUrl: './registry-list.component.html',
  styleUrls: ['./registry-list.component.css'],
})
export class RegistryListComponent implements OnInit {
  errorMessage: string;
  registries: Array<Registry>;

  constructor(private employeeService: RegistryService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getRegistry();
  }

  getRegistry() {
    this.employeeService.getRegistries()
      .subscribe(
        registries => this.registries = registries,
        error => this.errorMessage = <any>error
      );
  }

}
