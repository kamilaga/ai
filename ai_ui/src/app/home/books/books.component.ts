import { Component, OnInit } from '@angular/core';
import { Routes, ROUTER_DIRECTIVES} from '@angular/router';
import { ListComponent } from './list';
import { CreateComponent } from './create';
import { UpdateComponent } from './update';

@Component({
  moduleId: module.id,
  selector: 'app-books',
  templateUrl: 'books.component.html',
  styleUrls: ['books.component.css'],
    directives: [ROUTER_DIRECTIVES]
})
@Routes([
  { path: '/', component: ListComponent },
  { path: '/create', component: CreateComponent },
  { path: '/:id', component:  UpdateComponent}
])
export class BooksComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
