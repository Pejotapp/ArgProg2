import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../modelos/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  URL =   'https://localhost:8080/personas/';

  constructor(private http: HttpClient) {  }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'traer')
  }
}
