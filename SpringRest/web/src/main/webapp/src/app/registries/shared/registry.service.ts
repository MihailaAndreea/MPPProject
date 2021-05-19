import {Injectable} from '@angular/core';

import {HttpClient, HttpEvent} from "@angular/common/http";


import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";
import {Registry} from "./registry.model";


@Injectable()
export class RegistryService {
  private registryUrl = 'http://localhost:8080/test/api/registries';

  constructor(private httpClient: HttpClient) {
  }

  getRegistries(): Observable<Registry[]> {
    return this.httpClient
      .get<Record<'registries', Array<Registry>>>(this.registryUrl)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.registries),
      );
  }


  getRegistry(id: number): Observable<Registry> {
    return this.getRegistries()
      .pipe(
        map(registries => registries.find(registry => registry.id === id)),
        tap((response) => console.log(response))
      );
  }

}
