import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter, Routes } from '@angular/router';
import { AppComponent } from './app/app.component';
import { HomeComponent } from './app/home/home.component';
import { CarsComponent } from './app/cars/cars.component';
import { AddCarComponent } from './app/add-car/add-car.component';
import { CarComponent } from './app/car/car.component';
import { UsersComponent } from './app/users/users.component';
import { AddUserComponent } from './app/add-user/add-user.component';
import { ProfileComponent } from './app/profile/profile.component';
import { LoansComponent } from './app/loans/loans.component';
import { LoginComponent } from './app/login/login.component';
import { SignupComponent } from './app/signup/signup.component';
import { MarketComponent } from './app/market/market.component';
import { AddLoanComponent } from './app/add-loan/add-loan.component';
import { ReparationComponent } from './app/reparation/reparation.component';
import { ReparationsComponent } from './app/reparations/reparations.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent},
  { path: 'cars', component: CarsComponent },
  { path: 'addcar', component: AddCarComponent},
  { path: 'cars/:id', component: CarComponent},
  { path: 'users', component: UsersComponent},
  { path: 'addClient', component: AddUserComponent},
  { path: 'client/:id', component: ProfileComponent},
  { path: 'loans', component: LoansComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent},
  { path: 'market', component: MarketComponent},
  { path: 'addLoan/:id', component: AddLoanComponent},
  { path: 'reparations', component: ReparationsComponent}
];

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter(routes)
  ]
}).catch(err => console.error(err));