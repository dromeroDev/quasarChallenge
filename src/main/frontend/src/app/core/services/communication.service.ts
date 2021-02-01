import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as env} from '../../../environments/environment';
import { CommunicationResponse } from '@core/models/communicationResponse';

const BASE: string = env.serverUrl;
@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public topsecret(body: any) {
    return this.httpClient.post<CommunicationResponse>(BASE + "/topsecret", body);
  }
}
