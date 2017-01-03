import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  AuthorService, Author
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-create',
  templateUrl: 'create.component.html',
  styleUrls: ['create.component.css']
})
export class CreateComponent implements OnInit {
  author: Author;

  firstNameValidation: boolean = false;
  lastNameValidation: boolean = false;
  websiteValidation: boolean = false;

  constructor(
    private authorService: AuthorService,
    private router: Router
  ) { }

  ngOnInit() {
    this.author = new Author();
    this.author.firstName = '';
    this.author.lastName = '';
    this.author.websiteUrl = '';
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
    if (this.firstNameValidation || this.lastNameValidation || this.websiteValidation) {
      return;
    }
    this.createAuthor();
  }

  createAuthor() {
    this.authorService.createAuthor(this.author)
      .subscribe((author) => { console.log(author); this.router.navigate(['/authors']) }, (error) => console.log(error))
  }

}
