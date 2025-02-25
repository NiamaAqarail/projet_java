import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../services/client.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MessageService } from '../services/message.service';
import { LoanService } from '../services/loan.service';

@Component({
  selector: 'app-add-loan',
  imports: [SidebarComponent, CommonModule, FormsModule],
  templateUrl: './add-loan.component.html',
  styleUrl: './add-loan.component.css'
})
export class AddLoanComponent implements OnInit{
  loanStatusOptions = [
    { value: 'réservé', label: 'Réservé' },
    { value: 'terminé', label: 'Terminé' },
  ];
  constructor(
    private clientService: ClientService,
    private loanService: LoanService,
    private router : Router,
    private route: ActivatedRoute,
    private messageService : MessageService
  ){}
  clients: any = [] 
  // Initialize the form model
  loan: any = {}
  
  ngOnInit(): void {
    const car_id = this.route.snapshot.paramMap.get('car_id');
    this.loan = {
      dateDebut : '',
      dateFin : '',
      etat: 'réservé',
      client: {
        id: ''
      },
      voiture: {
        id: car_id
      }
    };
    this.getClients();
  }
  
  onSubmit() {
    this.loanService.addLoan(this.loan).subscribe({
      next: (response: any) => {
        console.log('Loan added successfully:', response);
  
        // Handle null or undefined response
        if (!response) {
          console.error('Received null or undefined response from the server.');
          this.messageService.setMessage('Failed to add loan: Invalid response from server.', false);
          return;
        }
  
        // Parse the response if it's a string
        let parsedResponse;
        try {
          parsedResponse = typeof response === 'string' ? JSON.parse(response) : response;
        } catch (error) {
          console.error('Failed to parse response:', error);
          this.messageService.setMessage('Failed to add loan: Invalid response format.', false);
          return;
        }
  
        // Check if the parsed response has a message
        if (parsedResponse && parsedResponse.message) {
          this.messageService.setMessage(parsedResponse.message, true);
        } else {
          this.messageService.setMessage('Loan added successfully!', true);
        }
  
        this.loan = {
          dateDebut : '',
          dateFin : '',
          etat: 'rejected',
          client: {
            id: ''
          },
          voiture : {
            id : ''
          }
        };
  
        this.router.navigate(['/loans']);
      },
      error: (error) => {
        console.error('Failed to add the loan:', error);
  
        // Handle null or undefined error
        if (!error || !error.error) {
          this.messageService.setMessage('Failed to add loan: Unknown error occurred.', false);
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
        this.router.navigate(['/loans']);
      }
    });
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
  
}
