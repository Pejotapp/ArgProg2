
package com.portfolio.Pjp.controlador;

import com.portfolio.Pjp.entidad.persona;
import com.portfolio.Pjp.interfac.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaControlador {
    @Autowired IPersonaServicio IPersonaServicio;
    
    @GetMapping("personas/traer")
    public List<persona> getpersona(){
        return IPersonaServicio.getpersona();
    }
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody persona Persona){
        IPersonaServicio.savepersona(Persona);
    return "La persona fue creada correctamente.";}
    
    
    @DeleteMapping("/personas/borrar/(id)")
    public String deletePersona(@PathVariable Long id){
     IPersonaServicio.deletepersona(id);
    return "La persona fue borrada correctamente.";}
    
    @PutMapping("/personas/editar/(id)")
    public persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
    persona persona = IPersonaServicio.findpersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevoImg);
    
    IPersonaServicio.savepersona(persona);
    return persona;}
}
