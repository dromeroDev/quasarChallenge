import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { CommunicationService } from '@core/services/communication.service';
import { CommunicationResponse } from '@core/models/communicationResponse';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
      const isSubmitted = form && form.submitted;
      return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
  }

@Component({
  selector: 'dialog-new-message',
  templateUrl: './dialogNewMessage.component.html',
  styleUrls: ['./dialogNewMessage.component.scss']
})
export class DialogNewMessageComponent {
    form: FormGroup;
    matcher = new MyErrorStateMatcher();
    response: CommunicationResponse | undefined;

    constructor(
        private formBuilder: FormBuilder,
        private dialogRef: MatDialogRef<DialogNewMessageComponent>,
        private communicationService: CommunicationService,
        @Inject(MAT_DIALOG_DATA) public data: Object) {
          this.form = this.formBuilder.group({
            messageFormControl: ['', [Validators.required]]
          });
        }
    
    onNoClick(): void {
      this.dialogRef.close();
    }

    sendMessage() {
      const body = this.getOffsetMessageForSatellite(this.form.get("messageFormControl")?.value);
      
      this.communicationService.topsecret(body).toPromise().then(
        res => {
          this.response = res;
        },
        err => {
          console.log(Error, err)
        }
      )
      
    }

    getOffsetMessageForSatellite(message: string) {
      const messageSeparated = message.split(" ");
      const data = {
        "satellites" : [
          {
            "name": "kenobi",
            "distance": this.getDistance(),
            "message": this.applyOffsetMessage(messageSeparated, 0)
          },
          {
            "name": "kenobi",
            "distance": this.getDistance(),
            "message": this.applyOffsetMessage(messageSeparated, 2)
          },
          {
            "name": "kenobi",
            "distance": this.getDistance(),
            "message": this.applyOffsetMessage(messageSeparated, 3)
          }
        ]
      }
      return data;
    }

    applyOffsetMessage(message: string[], offset: number) {
      let msj = new Array();
      for(let i = 0; i < message.length; i++) {
        if(offset === i) {
          msj[i] = "";
        } else {
          msj[i] = message[i];
        }
      }
      return msj;
    }

    getDistance() {
      return Math.random() * (200 - 100) + 100;
    }
}