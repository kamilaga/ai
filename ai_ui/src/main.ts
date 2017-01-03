import { bootstrap } from '@angular/platform-browser-dynamic';
import { enableProdMode } from '@angular/core';
import { HTTP_PROVIDERS } from '@angular/http';
import 'rxjs';


import { MasAppComponent, environment } from './app/';

if (environment.production) {
  enableProdMode();
}

bootstrap(MasAppComponent, [HTTP_PROVIDERS]);

