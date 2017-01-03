import { Component, OnInit } from '@angular/core';
import { Router, RouteSegment } from '@angular/router';

import {
  PublisherService, Publisher
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-update',
  templateUrl: 'update.component.html',
  styleUrls: ['update.component.css']
})
export class UpdateComponent implements OnInit {
  id: number;
  publisher: Publisher;

  constructor(
    private publisherService: PublisherService,
    private router: Router,
    private routeSegment: RouteSegment
  ) { }

  ngOnInit() {
    this.publisher = new Publisher();
    this.id = +this.routeSegment.getParam('id');
    this.publisherService.getPublisher(this.id)
      .subscribe((publisher) => { this.publisher = publisher; console.log(publisher as Publisher) }, (error) => { console.log(error); this.router.navigate(['/publishers']) });
  }

  updatePublisher() {
    this.publisherService.updatePublisher(this.publisher)
      .subscribe((publisher) => { console.log(publisher); this.router.navigate(['/publishers']) }, (error) => console.log(error))
  }

}
