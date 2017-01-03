import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Character } from '../index';

@Injectable()
export class CharacterService {

  constructor(private http: Http) { }

  getCharacters(): Observable<Character[]> {
    return this.http.get('/api/characters')
      .map(response => response.json());
  }

  createCharacter(character: Character): Observable<Character> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post('/api/characters', JSON.stringify(character), options)
      .map(response => response.json());
  }
}