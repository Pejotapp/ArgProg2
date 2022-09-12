/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pjp.Interface;

import com.portfolio.pjp.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    
    /*TRAER UNA LISTA DE PERSONA*/
    public List<Persona> getPersona();
    
    /*GUARDAR UNA PERSONA*/
    public void savePersona(Persona persona);
            
    /*ELIMINAR UNA PERSONA*/
    public void deletePersona(Long id);
    
    /*BUSCAR PERSONA POR ID*/
    public Persona findPersona(Long id);
}
