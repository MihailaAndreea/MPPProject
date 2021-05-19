import {Injectable} from '@angular/core';

import {HttpClient, HttpEvent} from "@angular/common/http";

import {ProductionLot} from "./production.model";

import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";


@Injectable()
export class ProductionLotService {
  private productionLotsUrl = 'http://localhost:8080/test/api/productionLots';

  constructor(private httpClient: HttpClient) {
  }

  getProductionLots(): Observable<ProductionLot[]> {
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(this.productionLotsUrl)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

  getProductionLot(id: number): Observable<ProductionLot> {
    return this.getProductionLots()
      .pipe(
        map(productionLots => productionLots.find(productionLot => productionLot.id === id)),
        tap((response) => console.log(response)),
      );
  }

  update(productionLot): Observable<ProductionLot> {
    const url = `${this.productionLotsUrl}/${productionLot.id}`;
    return this.httpClient
      .put<ProductionLot>(url, productionLot);
  }

  add(productionLot): Observable<ProductionLot>{
    const url = `${this.productionLotsUrl}`;
    return this.httpClient
      .post<ProductionLot>(url, productionLot);
  }

  // delete(id): Observable<HttpEvent<String>>{
  //   const url = `${this.productionLotsUrl}/${id}`;
  //   return this.httpClient
  //     .delete<String>(url, id);
  // }
  //
  filterByChocoID(id): Observable<ProductionLot[]>{
    const url = `${this.productionLotsUrl}/filterByChocoID/${id}`;
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(url)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

  findByOrderByChocolateIDAsc(): Observable<ProductionLot[]>{
    const url = `${this.productionLotsUrl}/findByOrderByChocolateIDAsc/`;
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(url)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

  filterByQuantity(quantity): Observable<ProductionLot[]>{
    const url = `${this.productionLotsUrl}/filterByQuantity/${quantity}`;
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(url)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

  filterByProductionDate(productionDate): Observable<ProductionLot[]>{
    const url = `${this.productionLotsUrl}/filterByProductionDate/${productionDate}`;
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(url)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

  filterByExpirationDate(expirationDate): Observable<ProductionLot[]>{
    const url = `${this.productionLotsUrl}/filterByExpirationDate/${expirationDate}`;
    return this.httpClient
      .get<Record<'productionLotDtoSet', Array<ProductionLot>>>(url)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.productionLotDtoSet)
      );
  }

}
