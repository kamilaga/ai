import { Component, OnInit } from '@angular/core';
import { Router, RouteSegment } from '@angular/router';

import {
  AuthorService, Author
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-update',
  templateUrl: 'update.component.html',
  styleUrls: ['update.component.css']
})
export class UpdateComponent implements OnInit {
  id: number;
  author: Author;

  firstNameValidation: boolean = false;
  lastNameValidation: boolean = false;
  websiteValidation: boolean = false;

  constructor(
    private authorService: AuthorService,
    private router: Router,
    private routeSegment: RouteSegment
  ) { }

  ngOnInit() {
    this.author = new Author();
    this.id = +this.routeSegment.getParam('id');
    this.authorService.getAuthor(this.id)
      .subscribe((author) => { this.author = author }, (error) => { console.log(error); this.router.navigate(['/authors']) });
  }

  validate() {
    this.firstNameValidation = false;
    this.lastNameValidation = false;
    this.websiteValidation = false;
    if (!this.author.firstName.trim() || this.author.firstName.length > 255) {
      this.firstNameValidation = true;
    }
    if (!this.author.lastName.trim() || this.author.lastName.length > 255) {
      this.lastNameValidation = true;
    }
    if (!this.author.websiteUrl.trim() || this.author.websiteUrl.length > 255) {
      this.websiteValidation = true;
    }
    if( this.firstNameValidation || this.lastNameValidation || this.websiteValidation){
      return;
    }
    this.updateAuthor();
  }

  updateAuthor() {
    this.authorService.updateAuthor(this.author)
      .subscribe((author) => { console.log(author); this.router.navigate(['/authors']) }, (error) => console.log(error))
  }

}