import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReparationService {

  private apiUrl = 'http://localhost:8081/reparation';
  constructor(private http: HttpClient) { }
  getReparations(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  deleteReparation(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
