import { Component, OnInit } from '@angular/core';
import { Router, Routes, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';
import {
  AuthorService, Author
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-list',
  templateUrl: 'list.component.html',
  styleUrls: ['list.component.css'],
    directives: [ROUTER_DIRECTIVES]
})
export class ListComponent implements OnInit {
  authors: Array<Author>;

  constructor(
    private authorService: AuthorService
  ) {
  }

  ngOnInit() {
    this.authorService.getAuthors()
      .subscribe(authors => this.authors = authors, (error) => console.log(error));
  }


}
