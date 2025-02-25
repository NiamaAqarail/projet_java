import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CarsComponent } from './cars/cars.component';
import { UsersComponent } from './users/users.component';
import { MarketComponent } from './market/market.component';
import { ProfileComponent } from './profile/profile.component';
import { LoansComponent } from './loans/loans.component';
import { CarComponent } from './car/car.component';
import { LoanComponent } from './loan/loan.component';
import { AddCarComponent } from './add-car/add-car.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'cars', component: CarsComponent},
    {path: 'users', component: UsersComponent},
    {path: 'market', component : MarketComponent},
    {path: 'profile', component : ProfileComponent},
    {path: 'loans', component: LoansComponent},
    {path: 'car', component: CarComponent},
    {path: 'loan', component: LoanComponent},
    {path: 'addcar', component: AddCarComponent}
];
