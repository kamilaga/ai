import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Author } from '../index';

@Injectable()
export class AuthorService {

  constructor(private http: Http) { }


  getAuthors(): Observable<Author[]> {
    return this.http.get('/api/authors')
      .map(response => response.json());
  }

  getAuthor(id: number): Observable<Author> {
    return this.http.get('/api/authors/' + id)
      .map(response => response.json());
  }

  createAuthor(author: Author): Observable<Author> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/authors', JSON.stringify(author), options)
      .map(response => response.json());
  }

  updateAuthor(author: Author): Observable<Author> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put('/api/authors/' + author.id, JSON.stringify(author), options)
      .map(response => response.json());
  }
}
