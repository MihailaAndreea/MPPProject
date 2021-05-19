import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductionLotsComponent} from "./productions/productions.component";
import {ProductionLotDetailComponent} from "./productions/production-detail/production-detail.component";
import {ChocolatesComponent} from "./chocolates/chocolates.component";
import {ChocolateNewComponent} from "./chocolates/chocolate-new/chocolate-new.component";
import {ChocolateUpdateComponent} from "./chocolates/chocolate-update/chocolate-update.component";
import {ChocolateDeleteComponent} from "./chocolates/chocolate-delete/chocolate-delete.component";
import {ProductionFilterComponent} from "./productions/production-server-filter/production-filter.component";
import {ProductionSort} from "./productions/production-server-sort/production-sort";
import {EmployeesComponent} from "./employees/employees.component";
import {RegistriesComponent} from "./registries/registries.component";
import {EmployeeFilterComponent} from "./employees/employee-filter/employee-filter.component";


const routes: Routes = [
  // {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'productionLots', component: ProductionLotsComponent},
  {path: 'productionLot/detail/:id', component: ProductionLotDetailComponent},
  {path: 'filterByChocoId/:id', component: ProductionFilterComponent},
  {path: 'sortedProductions', component: ProductionSort},

  {path: 'chocolates', component: ChocolatesComponent},
  {path: 'chocolate-new', component: ChocolateNewComponent},
  {path: 'chocolate-update/:id', component: ChocolateUpdateComponent},
  {path: 'chocolate-delete/:id', component: ChocolateDeleteComponent},

  {path: 'employees', component: EmployeesComponent},
  {path: 'filterByName/:name', component: EmployeeFilterComponent},

  {path: 'registries', component: RegistriesComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
