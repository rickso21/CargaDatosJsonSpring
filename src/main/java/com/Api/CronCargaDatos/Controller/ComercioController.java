package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Comercio;
import com.Api.CronCargaDatos.Repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Comercio")
public class ComercioController {

    @Autowired
    ComercioRepository comercioRepository;


    @GetMapping("/Consulta_Comercio")
    public List<Comercio> getAllComercio() {


        return comercioRepository.findAll();

    }


    @PostMapping("/Insertar_Comercio")
    public Comercio createComercio(@RequestBody Comercio comercio) {

        return comercioRepository.save(comercio);
    }


    @PutMapping("/Actualiza_Comercio/{id}")
    ResponseEntity<Comercio> ActualizarDatos(@PathVariable long id, @RequestBody Comercio comercioCarga) {
        Comercio ActualizarDatos = comercioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comercio not exist whith id:" + id));

        ActualizarDatos.setNombre(comercioCarga.getNombre());
        ActualizarDatos.setMcc(comercioCarga.getMcc());
        ActualizarDatos.setConsorcio(comercioCarga.getConsorcio());
        ActualizarDatos.setActivo(comercioCarga.getActivo());
        ActualizarDatos.setCategoria_id(comercioCarga.getCategoria_id());


        comercioRepository.save(ActualizarDatos);

        return ResponseEntity.ok(ActualizarDatos);

    }

    @DeleteMapping("/Eliminar_Comercio/{id}")
    public ResponseEntity<HttpStatus> deleteComercio(@PathVariable long id) {



        Comercio comercioCarga = comercioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found comercio: " + id));

        comercioRepository.delete(comercioCarga);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
