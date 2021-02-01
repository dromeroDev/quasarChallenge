import { Injectable } from '@angular/core';
import { Subject, Observable, ReplaySubject, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SpinnerService  {

  // private filterValueSubject : BehaviorSubject<boolean> = new BehaviorSubject(false);
  // public filterValues$: Observable<boolean>;

  // constructor() {
  //   this.filterValues$ = this.filterValueSubject.asObservable();
  // }

  // show() {
  //   this.filterValueSubject.next(true);
  // }

  // hide() {
  //   this.filterValueSubject.next(false);
  // }
}
