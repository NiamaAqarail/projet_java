import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private apiUrl = 'http://localhost:8081/voiture'; // Base URL for the backend

  constructor(private http: HttpClient) {}

  // Method to fetch all cars
  getAllCars(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

  // Method to add a new car
  addCar(car: any): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(`${this.apiUrl}/add`, car, { headers, responseType: 'text' });
  }
  deleteCar(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
  getCar(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/get?id=${id}`);
  }
  updateCar(car: any, id: number): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(`${this.apiUrl}/update/${id}`, car, { headers, responseType: 'text' });
  }
  
}