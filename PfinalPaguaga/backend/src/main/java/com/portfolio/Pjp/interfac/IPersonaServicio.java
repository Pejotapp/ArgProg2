
package com.portfolio.Pjp.interfac;

import com.portfolio.Pjp.entidad.persona;
import java.util.List;



public interface IPersonaServicio {
    //Trae una lista de persona
    public List<persona> getpersona();
    
    //Guarad un obj persona
    public void savepersona(persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletepersona(Long id);
    
    //buscar persona
    public persona findpersona(Long id);
    
}
