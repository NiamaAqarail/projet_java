import { Component } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-loan',
  imports: [SidebarComponent, CommonModule, FormsModule],
  templateUrl: './loan.component.html',
  styleUrl: './loan.component.css'
})
export class LoanComponent {
  loan = {
    clientName: 'John Doe',
    carModelAndBrand: 'BMW X5',
    startDate: '2024-02-01',
    endDate: '2024-02-10',
    status: 'Pending'
  };

  statusOptions = ['Approved', 'Rejected'];

  saveLoan() {
    console.log('Loan details saved:', this.loan);
    // Add logic to save loan details
  }
}
