import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { ReparationService } from '../services/reparation.service';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service';
import { throwIfEmpty } from 'rxjs';

@Component({
  selector: 'app-reparations',
  imports: [SidebarComponent, CommonModule],
  templateUrl: './reparations.component.html',
  styleUrl: './reparations.component.css'
})
export class ReparationsComponent implements OnInit{
  reparations: any [] = [];
  message: string = ''; // Variable to hold the message
  isSuccess: boolean = false;
  constructor(
    private reparationService : ReparationService,
    private router : Router,
    private messageService : MessageService
  ){}
  ngOnInit(): void {
      this.getReparations();
  }
  getReparations(): void {
    
    this.reparationService.getReparations().subscribe(
      (data) => {
        this.reparations = data;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching loans:', error);
      }
    );
  }
  deleteReparation(id: number): void{
    this.reparationService.deleteReparation(id).subscribe({
      next: (response: any) => {
        console.log('reparation deleted successfully:', response);
        this.messageService.setMessage(response.message, true);
        this.getReparations();
      },
      error: (error) => {
        console.error('Failed to delete the reparation:', error); 
        this.messageService.setMessage(error.error.message || 'Failed to delete the reparation.', false);
        this.getReparations();
      }
    });
  }
}
