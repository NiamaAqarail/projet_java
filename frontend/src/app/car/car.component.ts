import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from '../services/car.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-car',
  imports: [SidebarComponent, CommonModule, FormsModule],
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent implements OnInit {

  car: any = {};
  isUpdateMode: boolean = false;
  constructor(
    private carService: CarService,
    private router: Router,
    private route: ActivatedRoute, // Inject ActivatedRoute
    private messageService: MessageService
  ) {}


  onSubmit() {
    this.updateCar();
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id'); // Get the car ID from the route
    if (id) {
      this.getCarDetails(+id);
    }
  }

  getCarDetails(id: number): void {
    this.carService.getCar(id).subscribe({
      next: (data) => {
        this.car = data; // Set the car details
      },
      error: (error) => {
        console.error('Error fetching car details:', error);
      }
    });
  }
  updateCar() {
    const id = this.route.snapshot.paramMap.get('id'); // Get the car ID from the route
    if (id) {
      this.carService.updateCar(this.car, +id).subscribe({
        next: (response: any) => {
          console.log('Car updated successfully:', response); // Log the response
          this.messageService.setMessage(response.message, true); // Set success message
          this.router.navigate(['/cars']);
        },
        error: (error) => {
          console.error('Failed to update the car:', error); // Log the error
          this.messageService.setMessage(error.error.message || 'Failed to update the car.', false); // Set failure message
          this.router.navigate(['/cars']);
        }
      });
    }
  }
}
