// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  pageVar: '{$p}',
  sizeVar: '{$s}',
  idVar: '{$id}',
  // pageParam: 'page=' + this.pageVars ,
  // sizeParam: 'size=' + this.sizeVar,
  ORDER_URL: 'http://localhost:8080/orders?page={$p}&size={$s}',
  SEJMOMETR_URL: 'https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne/{$id}'
};
