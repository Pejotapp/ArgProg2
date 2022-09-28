import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/modelos/experiencia';
import { SExperienciaService } from 'src/app/modelos/s-experiencia.service';
import { TokenService } from 'src/app/servicio/token.service';

@Component({
  selector: 'app-experiencias',
  templateUrl: './experiencias.component.html',
  styleUrls: ['./experiencias.component.css']
})
export class ExperienciasComponent implements OnInit {
expe: Experiencia[] = [];



  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia()
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {this.isLogged = false;}
  }


cargarExperiencia(): void {
  this.sExperiencia.lista().subscribe(data => {this.expe = data;})
}
}
