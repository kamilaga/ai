import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Genre } from '../index';

@Injectable()
export class GenreService {

  constructor(private http: Http) { }

  getGenres(): Observable<Genre[]> {
    return this.http.get('/api/genres')
      .map(response => response.json());
  }

  createGenre(genre: Genre): Observable<Genre> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/genres', JSON.stringify(genre), options)
      .map(response => response.json());
  }
}
