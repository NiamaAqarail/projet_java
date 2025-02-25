import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:8081/client'; // Backend URL

  constructor(private http: HttpClient) {}

  // Get all clients
  getClients(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  addClient(client: any): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(`${this.apiUrl}/add`, client, { headers });
  }
  deleteClient(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
  getClient(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/get?id=${id}`);
  }
  updateClient(client: any, id: number): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put(`${this.apiUrl}/update/${id}`, client, { headers});
  }

}
