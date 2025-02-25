import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.css'
})
export class CarsComponent implements OnInit {
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

  navigateToAddCar() {
    this.router.navigate(['/addcar']);
  }
  showDetails(car: any) {
    this.router.navigate(['/cars', car.id]);
  }
}