import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { ClientService } from '../services/client.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-users',
  imports: [CommonModule, SidebarComponent],
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  
  clients: any[] = [];
  message: string = ''; // Variable to hold the message
  isSuccess: boolean = false;

  constructor(
    private clientService: ClientService,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.getClients();
    this.checkForMessage();
  }

  getClients(): void{
    this.clientService.getClients().subscribe(
      (data) => {
        this.clients = data;
      },
      (error) => {
        console.error('error fetching clients:', error);
      }
    );
  }
  navigateToAddClient() {
    this.router.navigate(['/addClient']).catch(err => {
      console.error('Navigation failed:', err);
    });
  }
  showProfile(id: number){
    this.router.navigate(['/client',id]).catch(err => {
      console.error('Navigation failed:', err);
    });
  }

  checkForMessage() {
    const { message, isSuccess } = this.messageService.getMessage(); // Get the message
    if (message) {
      this.message = message;
      this.isSuccess = isSuccess;
      setTimeout(() => {
        this.messageService.clearMessage(); // Clear the message after 5 seconds
        this.message = '';
      }, 5000);
    }
  }
  deleteClient(id: number): void{
    this.clientService.deleteClient(id).subscribe({
      next: (response: any) => {
        console.log('Client deleted successfully:', response);
        this.messageService.setMessage(response.message, true);
        this.getClients();
      },
      error: (error) => {
        console.error('Failed to delete the client:', error); 
        this.messageService.setMessage(error.error.message || 'Failed to delete the client.', false);
      }
    });
  }

}
