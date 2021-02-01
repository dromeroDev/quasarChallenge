import { NgModule } from "@angular/core";

import { LayoutComponent } from "./layout.component";
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";

import { RouterModule } from "@angular/router";
import { SharedModule } from "@shared/shared.module";

@NgModule({
  imports: [
    RouterModule,
    SharedModule
  ],
  declarations: [
    LayoutComponent,
    HeaderComponent,
    FooterComponent,
  ],
  exports: [
    LayoutComponent,
    HeaderComponent,
    FooterComponent,
  ],
})
export class LayoutModule {}
