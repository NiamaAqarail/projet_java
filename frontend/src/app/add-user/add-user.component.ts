import { Component } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MessageService } from '../services/message.service';
import { Router } from '@angular/router';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-add-user',
  imports: [SidebarComponent, CommonModule, FormsModule],
  templateUrl: './add-user.component.html',
  styleUrl: './add-user.component.css'
})
export class AddUserComponent {
  client: any = {
    user: {
      username : '',
      email : '',
      password : '',
      type : ''
    },
    nom : '',
    prenom : '',
    cni : '',
    tel : '',
    adresse : '',
    numPermis : ''
  }
  constructor(
    private clientService: ClientService,
    private router: Router,
    private messageService: MessageService 
  ){}
  onSubmit() {
    this.clientService.addClient(this.client).subscribe({
      next: (response: any) => {
        console.log('Client added successfully:', response);
  
        // Handle null or undefined response
        if (!response) {
          console.error('Received null or undefined response from the server.');
          this.messageService.setMessage('Failed to add client: Invalid response from server.', false);
          return;
        }
  
        // Parse the response if it's a string
        let parsedResponse;
        try {
          parsedResponse = typeof response === 'string' ? JSON.parse(response) : response;
        } catch (error) {
          console.error('Failed to parse response:', error);
          this.messageService.setMessage('Failed to add client: Invalid response format.', false);
          return;
        }
  
        // Check if the parsed response has a message
        if (parsedResponse && parsedResponse.message) {
          this.messageService.setMessage(parsedResponse.message, true);
        } else {
          this.messageService.setMessage('Client added successfully!', true);
        }
  
        // Reset the form
        this.client = {
          user: {
            username: '',
            email: '',
            password: '',
            type: ''
          },
          nom: '',
          prenom: '',
          cni: '',
          tel: '',
          adresse: '',
          numPermis: ''
        };
  
        // Navigate back to the users page
        this.router.navigate(['/users']);
      },
      error: (error) => {
        console.error('Failed to add the client:', error);
  
        // Handle null or undefined error
        if (!error || !error.error) {
          this.messageService.setMessage('Failed to add client: Unknown error occurred.', false);
        } else {
          // Parse the error message if it's a string
          let errorMessage = error.error;
          if (typeof error.error === 'string') {
            try {
              errorMessage = JSON.parse(error.error).message || error.error;
            } catch (e) {
              console.error('Failed to parse error message:', e);
            }
          }
  
          this.messageService.setMessage(errorMessage, false);
        }
  
        // Navigate back to the users page
        this.router.navigate(['/users']);
      }
    });
  }
}
