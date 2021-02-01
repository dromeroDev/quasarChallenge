import { RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MaterialModule } from "./material/material.module";
import { ReactiveFormsModule } from "@angular/forms";
import { DialogNewMessageComponent } from "./components/dialogNewMessage/dialogNewMessage.component";


@NgModule({
  declarations: [
    DialogNewMessageComponent,
  ],
  imports: [
    CommonModule, 
    RouterModule,
    ReactiveFormsModule,
    MaterialModule,
  ],
  exports: [
    MaterialModule,
    DialogNewMessageComponent
  ],
})
export class SharedModule {}
