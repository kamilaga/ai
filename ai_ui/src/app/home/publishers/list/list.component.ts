import { Component, OnInit } from '@angular/core';
import { Router, Routes, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';
import {
  PublisherService, Publisher
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-list',
  templateUrl: 'list.component.html',
  styleUrls: ['list.component.css'],
    directives: [ROUTER_DIRECTIVES]
})
export class ListComponent implements OnInit {
  publishers: Array<Publisher>;

  constructor(
    private publisherService: PublisherService
  ) {
  }

  ngOnInit() {
    this.publisherService.getPublishers()
      .subscribe(publishers => this.publishers = publishers, (error) => console.log(error));
  }


}
