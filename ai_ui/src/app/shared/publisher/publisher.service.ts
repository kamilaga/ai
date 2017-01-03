import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Publisher } from '../index';

@Injectable()
export class PublisherService {

  constructor(private http: Http) { }

  getPublishers(): Observable<Publisher[]> {
    return this.http.get('/api/publishers')
      .map(response => response.json());
  }

  getPublisher(id: number): Observable<Publisher> {
    return this.http.get('/api/publishers/'+id)
      .map(response => response.json());
  }

  createPublisher(publisher: Publisher): Observable<Publisher> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/publishers', JSON.stringify(publisher), options)
      .map(response => response.json());
  }

  updatePublisher(publisher: Publisher): Observable<Publisher> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put('/api/publishers/' + publisher.id, JSON.stringify(publisher), options)
      .map(response => response.json());
  }

}