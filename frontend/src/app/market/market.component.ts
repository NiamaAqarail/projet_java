import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-market',
  imports: [CommonModule, SidebarComponent],
  templateUrl: './market.component.html',
  styleUrl: './market.component.css'
})
export class MarketComponent implements OnInit{
  cars: any[] = [];
    message: string = '';
    isSuccess: boolean = false;
  
    constructor(
      private carService: CarService,
      private router: Router,
      private messageService: MessageService
    ) {}
  
    ngOnInit(): void {
      this.getCars();
      this.checkForMessage();
    }
  
    getCars(): void {
      this.carService.getAllCars().subscribe(
        (data) => {
          this.cars = data;
        },
        (error) => {
          console.error('Error fetching cars:', error);
        }
      );
    }
    
    deleteCar(id: number): void {
      this.carService.deleteCar(id).subscribe({
        next: (response: any) => {
          console.log('Car deleted successfully:', response);
          this.messageService.setMessage(response.message, true);
          this.getCars(); // Refresh the list of cars
        },
        error: (error) => {
          console.error('Failed to delete the car:', error); 
          this.messageService.setMessage(error.error.message || 'Failed to delete the car.', false);
        }
      });
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
    loanCar(car_id: number){
      this.router.navigate(['/addLoan',car_id]);
    }
    showDetails(car: any) {
      this.router.navigate(['/cars', car.id]);
    }
}
