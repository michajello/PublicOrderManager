import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { PublicOrderManagerSharedLibsModule, PublicOrderManagerSharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [PublicOrderManagerSharedLibsModule, PublicOrderManagerSharedCommonModule],
    declarations: [HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    exports: [PublicOrderManagerSharedCommonModule, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PublicOrderManagerSharedModule {}
