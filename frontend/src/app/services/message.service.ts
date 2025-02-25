import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor() { }
  private message: string = '';
  private isSuccess: boolean = false;

  setMessage(message: string, isSuccess: boolean) {
    this.message = message;
    this.isSuccess = isSuccess;
  }

  getMessage(): { message: string, isSuccess: boolean } {
    return { message: this.message, isSuccess: this.isSuccess };
  }

  clearMessage() {
    this.message = '';
    this.isSuccess = false;
  }
}
