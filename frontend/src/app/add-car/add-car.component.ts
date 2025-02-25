import { Component } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-add-car',
  imports: [SidebarComponent, CommonModule, FormsModule],
  templateUrl: './add-car.component.html',
  styleUrl: './add-car.component.css'
})
export class AddCarComponent {
  car: any = {
    marque: '',
    model: '',
    anneeFab: null,
    carburant: '',
    immatriculation: '',
    prix: null,
    etat: '',
    image: ''
  };

  constructor(
    private carService: CarService,
    private router: Router,
    private messageService: MessageService // Inject MessageService
  ) {}

  onSubmit() {
    this.carService.addCar(this.car).subscribe({
      next: (response: any) => {
        console.log('Car added successfully:', response);
         // Log the response
         console.log(JSON.parse(response));
        this.messageService.setMessage(JSON.parse(response).message, true); // Set success message
        this.car = { marque: '', model: '', anneeFab: null, carburant: '', immatriculation: '', prix: null, etat: '', image: '' }; // Reset the form
        this.router.navigate(['/cars']);
      },
      error: (error) => {
        console.error('Failed to add the car:', error); // Log the error
        this.messageService.setMessage(error.error || 'Failed to add the car.', false); // Set failure message
        this.router.navigate(['/cars']);
      }
    });
  }
}
