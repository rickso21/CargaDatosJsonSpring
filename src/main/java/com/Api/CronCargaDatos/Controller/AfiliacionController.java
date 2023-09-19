package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Afiliacion;
import com.Api.CronCargaDatos.Repository.AfiliacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Afiliacion")
public class AfiliacionController {

    @Autowired
    AfiliacionRepository afiliacionRepository;
    @GetMapping("/Consulta_Afiliacion")
    public List<Afiliacion> getAllAfiliacionCarga() {
        return afiliacionRepository.findAll();
    }


    @PostMapping("/Insertar_Afiliacion")
    public Afiliacion createAfiliacion(@RequestBody Afiliacion afiliacion) {

        return afiliacionRepository.save(afiliacion);
    }

    @PutMapping("/Actualiza_Afiliacion/{id}")
    ResponseEntity<Afiliacion> ActualizarDatos(@PathVariable long id, @RequestBody Afiliacion afiliacionCarga) {
        Afiliacion ActualizarDatos = afiliacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Afiliacion not exist whith id:" + id));

        ActualizarDatos.setNumero(afiliacionCarga.getNumero());
        // ActualizarDatos.getActivo(afiliacionCarga.getActivo());
        ActualizarDatos.setActivo(afiliacionCarga.getActivo());
        ActualizarDatos.setRazon_social_id(afiliacionCarga.getRazon_social_id());
        ActualizarDatos.setSucursal_id(afiliacionCarga.getSucursal_id());
        afiliacionRepository.save(ActualizarDatos);


        return ResponseEntity.ok(ActualizarDatos);

    }

    @DeleteMapping("/Eliminar_Afiliacion/{id}")
    public ResponseEntity<HttpStatus> deleteAfiliacion(@PathVariable long id) {

        Afiliacion afiliacion_carga = afiliacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found afiliacion: " + id));

        afiliacionRepository.delete(afiliacion_carga);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
