import { Component } from '@angular/core';
import { AboutComponent } from "../about/about.component";
import { FooterComponent } from "../footer/footer.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [AboutComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private router: Router){}
  goToMarket(){
    this.router.navigate(['/market']);
  }
}
