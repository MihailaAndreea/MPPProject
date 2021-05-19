import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {ProductionLotDetailComponent} from './productions/production-detail/production-detail.component';
import {ProductionLotService} from './productions/shared/production.service';
import {ProductionLotListComponent} from './productions/production-list/production-list.component';
import {ProductionLotsComponent} from './productions/productions.component';
import {ChocolateListComponent} from './chocolates/chocolate-list/chocolate-list.component';
import {ChocolateNewComponent} from './chocolates/chocolate-new/chocolate-new.component';
import {ChocolatesComponent} from './chocolates/chocolates.component';
import {ChocolateService} from './chocolates/shared/chocolate.service';
import {ChocolateUpdateComponent} from "./chocolates/chocolate-update/chocolate-update.component";
import {ChocolateDeleteComponent} from "./chocolates/chocolate-delete/chocolate-delete.component";
import {ProductionFilterComponent} from "./productions/production-server-filter/production-filter.component";
import {ProductionSort} from "./productions/production-server-sort/production-sort";
import {EmployeesComponent} from "./employees/employees.component";
import {EmployeeListComponent} from "./employees/employee-list/employee-list.component";
import {EmployeeService} from "./employees/shared/employee.service";
import {RegistriesComponent} from "./registries/registries.component";
import {RegistryListComponent} from "./registries/registries-list/registry-list.component";
import {RegistryService} from "./registries/shared/registry.service";
import {EmployeeFilterComponent} from "./employees/employee-filter/employee-filter.component";


@NgModule({
  declarations: [
    AppComponent,
    ProductionLotDetailComponent,
    ProductionLotsComponent,
    ProductionLotListComponent,
    ChocolateListComponent,
    ChocolateNewComponent,
    ChocolatesComponent,
    ChocolateUpdateComponent,
    ChocolateDeleteComponent,
    ProductionFilterComponent,
    ProductionSort,
    EmployeesComponent,
    EmployeeListComponent,
    RegistriesComponent,
    RegistryListComponent,
    EmployeeFilterComponent,
  ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule,
    ],
  providers: [ProductionLotService, ChocolateService, EmployeeService, RegistryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
