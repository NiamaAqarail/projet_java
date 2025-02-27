import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-dash-header',
  imports: [CommonModule, MatButtonModule, MatIconModule, MatToolbarModule, RouterLink],
  templateUrl: './dash-header.component.html',
  styleUrl: './dash-header.component.css'
})
export class DashHeaderComponent {

}
