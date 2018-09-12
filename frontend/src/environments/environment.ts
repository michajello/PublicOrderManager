// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  pageVar: '{$p}',
  sizeVar: '{$s}',
  idVar: '{$id}',
  // pageParam: 'page=' + this.pageVars ,
  // sizeParam: 'size=' + this.sizeVar,
  startDateVar: 'startDate=',
  finishDateVar: 'finishDate=',
  voivodeshipVar: 'voivodeshipID=',
  orderModeVar: 'orderMode=',
  orderTypeVar: 'orderType=',
  orderKindModeVar: 'orderKind=',

  SERVER_URL: 'https://localhost:8080',
  ORDER_URL: 'http://localhost:8080/orders?page={$p}&size={$s}&startDate=&voivodeshipID=&finishDate=&orderMode=&orderType=&orderKind=',
  SEJMOMETR_URL: 'https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne/{$id}'
};

/*
 * In development mode, for easier debugging, you can ignore zone related error
 * stack frames such as `zone.run`/`zoneDelegate.invokeTask` by importing the
 * below file. Don't forget to comment it out in production mode
 * because it will have a performance impact when errors are thrown
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
