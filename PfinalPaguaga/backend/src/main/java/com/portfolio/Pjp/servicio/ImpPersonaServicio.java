
package com.portfolio.Pjp.servicio;

import com.portfolio.Pjp.entidad.persona;
import com.portfolio.Pjp.interfac.IPersonaServicio;
import com.portfolio.Pjp.repositorio.IPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaServicio implements IPersonaServicio{
    @Autowired IPersonaRepositorio IPersonaRepositorio;
    
    @Override
    public List<persona> getpersona() {
       List<persona> persona = IPersonaRepositorio.findAll();
       return persona;
    }

    @Override
    public void savepersona(persona Persona) {
        IPersonaRepositorio.save(Persona);
    }

    @Override
    public void deletepersona(Long id) {
        IPersonaRepositorio.deleteById(id);
    }

    @Override
    public persona findpersona(Long id) {
        persona persona = IPersonaRepositorio.findById(id).orElse(null);
        return persona;
        
    }
    
}
