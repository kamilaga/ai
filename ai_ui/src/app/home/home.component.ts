import { Component, OnInit } from '@angular/core';
import { Routes, ROUTER_DIRECTIVES} from '@angular/router';
import { BooksComponent } from './books';


@Component({
  moduleId: module.id,
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.css'],
  directives: [ROUTER_DIRECTIVES]
})
@Routes([
  { path: '/', component: BooksComponent }
])
export class HomeComponent {

}