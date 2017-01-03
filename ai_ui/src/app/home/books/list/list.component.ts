import { Component, OnInit } from '@angular/core';
import { Router, Routes, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';
import {
  BookService, Book
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-list',
  templateUrl: 'list.component.html',
  styleUrls: ['list.component.css'],
  directives: [ROUTER_DIRECTIVES]
})
export class ListComponent implements OnInit {
  expandedBookId: number = -1;
  books: Array<Book>;

  constructor(
    private bookService: BookService
  ) {
  }

  ngOnInit() {
    this.bookService.getBooks()
      .subscribe((books) => this.books = books, (error) => console.log(error));
  }

  expandBookInfo(id: number){
    if (this.expandedBookId == id){
      this.expandedBookId = -1;
    } else {
      this.expandedBookId = id;
    }

  }
}
