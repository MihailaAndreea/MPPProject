import {Injectable} from '@angular/core';

import {HttpClient, HttpEvent} from "@angular/common/http";


import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";
import {Chocolate} from "./chocolate.model";


@Injectable()
export class ChocolateService {
  private chocolatesUrl = 'http://localhost:8080/test/api/chocolates';

  constructor(private httpClient: HttpClient) {
  }

  getChocolates(): Observable<Chocolate[]> {
    return this.httpClient
      .get<Record<'chocolates', Array<Chocolate>>>(this.chocolatesUrl)
      .pipe(
        tap((response) => console.log(response)),
        map((response) => response.chocolates),
      );
  }

  saveChocolate(chocolate: Chocolate): Observable<Chocolate> {
    return this.httpClient
      .post<Chocolate>(this.chocolatesUrl, chocolate);
  }

  getChocolate(id: number): Observable<Chocolate> {
    return this.getChocolates()
      .pipe(
        map(chocolates => chocolates.find(chocolate => chocolate.id === id)),
        tap((response) => console.log(response))
      );
  }

  update(chocolate): Observable<Chocolate> {
    const url = `${this.chocolatesUrl}/${chocolate.id}`;
    console.log("updating chocolate", chocolate.id);
    return this.httpClient
      .put<Chocolate>(url, chocolate);
  }

  delete(id: number): Observable<any>{
    const url = `${this.chocolatesUrl}/${id}`;
    console.log("url", url);
    return this.httpClient
      .delete(url);
  }

  // getStudent(id: number): Observable<Student> {
  //   return this.getStudents()
  //     .pipe(
  //       map(students => students.find(student => student.id === id))
  //     );
  // }
  //
  // update(student): Observable<Student> {
  //   const url = `${this.disciplinesUrl}/${student.id}`;
  //   return this.httpClient
  //     .put<Student>(url, student);
  // }

}
