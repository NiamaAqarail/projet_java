import { Component, OnInit } from '@angular/core';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { ClientService } from '../services/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from '../services/message.service';


@Component({
  selector: 'app-profile',
  imports: [SidebarComponent,CommonModule,
    FormsModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  client: any = {};
  constructor(
      private clientService: ClientService,
      private router: Router,
      private route: ActivatedRoute,
      private messageService: MessageService
  ) {}
  onSubmit() {
    this.updateClient();
  }  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.getProfile(+id);
    }
  }
  getProfile(id: number): void {
    this.clientService.getClient(id).subscribe({
      next: (data) => {
        this.client = data;
      },
      error: (error) => {
        console.error('Error fetching profile details:', error);
      }
    });
  }
  updateClient() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.clientService.updateClient(this.client, +id).subscribe({
        next: (response: any) => {
          console.log('client updated successfully:', response);
          this.messageService.setMessage(response.message, true);
          this.router.navigate(['/users']);
        },
        error: (error) => {
          console.error('Failed to update the client:', error);
          this.messageService.setMessage(error.error.message || 'Failed to update the client.', false);
          this.router.navigate(['/users']);
        }
      });
    }
  }
  saveChanges() {
    console.log('Updated Client Info:', this.client);
  }
}
