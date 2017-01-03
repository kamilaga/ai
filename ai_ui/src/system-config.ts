/***********************************************************************************************
 * User Configuration.
 **********************************************************************************************/
/** Map relative paths to URLs. */
const map: any = {
  'ng2-notifications': './vendor/ng2-notifications'
};

/** User packages configuration. */
const packages: any = {
  'ng2-notifications': {
    defaultExtension: 'js',
    main: 'ng2-notifications.js'
  }
};

////////////////////////////////////////////////////////////////////////////////////////////////
/***********************************************************************************************
 * Everything underneath this line is managed by the CLI.
 **********************************************************************************************/
const barrels: string[] = [
  // Angular specific barrels.
  '@angular/core',
  '@angular/common',
  '@angular/compiler',
  '@angular/http',
  '@angular/router',
  '@angular/platform-browser',
  '@angular/platform-browser-dynamic',

  // Thirdparty barrels.
  //'rxjs',

  // App specific barrels.
  'app',
  'ng2-notifications',
  'app/shared',
  'app/home',
  'app/home/authors',
  'app/home/authors/create',
  'app/home/authors/list',
  'app/home/authors/update',
  'app/home/books',
  'app/home/books/create',
  'app/home/books/list',
  'app/home/books/update',
  'app/home/publishers',
  'app/home/publishers/create',
  'app/home/publishers/list',
  'app/home/publishers/update',
  /** @cli-barrel */
];

const cliSystemConfigPackages: any = {};
barrels.forEach((barrelName: string) => {
  cliSystemConfigPackages[barrelName] = { main: 'index' };
});

cliSystemConfigPackages['rxjs'] = { main: 'Rx' };

/** Type declaration for ambient System. */
declare var System: any;

// Apply the CLI SystemJS configuration.
System.config({
  map: {
    '@angular': 'vendor/@angular',
    'rxjs': 'vendor/rxjs',
    'main': 'main.js',
    'ng2-notifications': 'vendor/ng2-notifications',
  },
  packages: cliSystemConfigPackages
});

// Apply the user's configuration.
System.config({ map, packages });
