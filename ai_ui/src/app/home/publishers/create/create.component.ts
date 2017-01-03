import { Component, OnInit } from '@angular/core';
import { NgForm }    from '@angular/common';
import { Router } from '@angular/router';
import {
  PublisherService, Publisher
} from '../../../shared';


@Component({
  moduleId: module.id,
  selector: 'app-create',
  templateUrl: 'create.component.html',
  styleUrls: ['create.component.css']
})
export class CreateComponent implements OnInit {
  publisher: Publisher;

  constructor(
    private publisherService: PublisherService,
    private router: Router
  ) { }

  ngOnInit() {
    this.publisher = new Publisher();
  }

  createPublisher() {
    this.publisherService.createPublisher(this.publisher)
      .subscribe((publisher) => { console.log(publisher); this.router.navigate(['/publishers']) }, (error) => console.log(error))
  }

}
