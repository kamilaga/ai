import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Series } from '../index';

@Injectable()
export class SeriesService {

  constructor(private http: Http) { }

  getSeries(): Observable<Series[]> {
    return this.http.get('/api/series')
      .map(response => response.json());
  }

  createSeries(series: Series): Observable<Series> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/series', JSON.stringify(series), options)
      .map(response => response.json());
  }
}