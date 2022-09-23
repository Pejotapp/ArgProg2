
package com.portfolio.pjp.Controler;

import com.portfolio.pjp.Dto.dtoExperiencia;
import com.portfolio.pjp.Entity.Experiencia;
import com.portfolio.pjp.Security.Controller.Mensaje;
import com.portfolio.pjp.Service.SExperiencia;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    
   public ResponseEntity<List<Experiencia>> list(){
   List<Experiencia> list = sExperiencia.list();
   return new ResponseEntity(list, HttpStatus.OK);}
   
   public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
   if(StringUtils.isBlank(dtoexp.getNombreE()))
       return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
   if(sExperiencia.existsByNombreE(dtoexp.getNombreE()))
       return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
   
   Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
   sExperiencia.save(experiencia);
   return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
   }
   
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
   if(!sExperiencia.existsById(id))
       return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
   
   if(sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
       return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
   
   if (StringUtils.isBlank(dtoexp.getNombreE()))
       return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
   
   Experiencia experiencia = sExperiencia.getOne(id).get();
   experiencia.setNombreE(dtoexp.getNombreE());
   experiencia.setDescripcionE((dtoexp.getDescripcionE()));
   
   sExperiencia.save(experiencia);
   return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
   }
   
   public ResponseEntity<?> delete(@PathVariable("id") int id){
   
   if(!sExperiencia.existsById(id))
       return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
   sExperiencia.delete(id);
   
   return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
   }
}