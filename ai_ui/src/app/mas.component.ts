import { Component, OnInit } from '@angular/core';
import { Router, Routes, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';
// import { PushNotificationComponent } from 'ng2-notifications';
import { HomeComponent } from './home';
import { AuthorsComponent } from './home/authors';
import { BooksComponent } from './home/books';
import { PublishersComponent } from './home/publishers';
import {
  AuthorService,
  SeriesService,
  GenreService,
  CharacterService,
  PublisherService,
  BookService
} from './shared';

@Component({
  moduleId: module.id,
  selector: 'mas-app',
  templateUrl: 'mas.component.html',
  styleUrls: ['mas.component.css'],
  directives: [ROUTER_DIRECTIVES],
  providers: [
    ROUTER_PROVIDERS,
    AuthorService,
    SeriesService,
    GenreService,
    CharacterService,
    PublisherService,
    BookService
  ]
})
@Routes([
  { path: '/', component: HomeComponent, },
  { path: '/authors', component: AuthorsComponent },
  { path: '/books', component: BooksComponent },
  { path: '/publishers', component: PublishersComponent }

])
export class MasAppComponent implements OnInit {

  ngOnInit() {
  }

  constructor(private router: Router
  ) { }


}
