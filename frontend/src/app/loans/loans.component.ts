import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { LoanService } from '../services/loan.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-loans',
  imports: [CommonModule, SidebarComponent],
  templateUrl: './loans.component.html',
  styleUrls: ['./loans.component.css']
})
export class LoansComponent implements OnInit {
  loans: any[] = [];
  message: string = ''; // Variable to hold the message
  isSuccess: boolean = false;
  constructor(
    private loanService: LoanService,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.getLoans();
    this.checkForMessage();
  }
  
  checkForMessage() {
    const { message, isSuccess } = this.messageService.getMessage();
    if (message) {
      this.message = message;
      this.isSuccess = isSuccess;
      setTimeout(() => {
        this.messageService.clearMessage();
        this.message = '';
      }, 5000);
    }
  }
  getLoans(): void {
    
    this.loanService.getLoans().subscribe(
      (data) => {
        this.loans = data;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching loans:', error);
      }
    );
  }
  deleteLoan(id: number): void{
    this.loanService.deleteLoan(id).subscribe({
      next: (response: any) => {
        console.log('Loan deleted successfully:', response);
        this.messageService.setMessage(response.message, true);
        this.getLoans();
      },
      error: (error) => {
        console.error('Failed to delete the loan:', error); 
        this.messageService.setMessage(error.error.message || 'Failed to delete the loan.', false);
        this.getLoans();
      }
    });
  }
}
