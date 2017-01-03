import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Book } from '../index';

@Injectable()
export class BookService {

  constructor(private http: Http) { }

  getBooks(): Observable<Book[]> {
    return this.http.get('/api/books')
      .map(response => response.json());
  }

  getBook(id: number): Observable<Book> {
    return this.http.get('/api/books/' + id)
      .map(response => response.json());
  }

  createBook(book: Book): Observable<Book> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/books', JSON.stringify(book), options)
      .map(response => response.json());
  }

  updateBook(book: Book): Observable<Book> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.put('/api/books/' + book.id, JSON.stringify(book), options)
      .map(response => response.json());
  }
}