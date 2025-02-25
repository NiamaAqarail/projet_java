import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiUrl = 'http://localhost:8081/location';
  constructor(private http: HttpClient) { }
  getLoans(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  deleteLoan(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
  addLoan(loan: any): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(`${this.apiUrl}/add`, loan, { headers });
  }
}
