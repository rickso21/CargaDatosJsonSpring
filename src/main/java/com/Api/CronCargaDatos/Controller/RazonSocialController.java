package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Razon_Social;
import com.Api.CronCargaDatos.Repository.RazonSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RazonSocial")
public class RazonSocialController {

        @Autowired
        RazonSocialRepository razonSocialCargaRepository;

        @GetMapping("/consulta_RzSocial")
        public List<Razon_Social> getAllRzSocial() {
                return razonSocialCargaRepository.findAll();
        }



        @PostMapping("/Inserta_RzSocial")
        public Razon_Social createRzSocial(@RequestBody Razon_Social razonSocialCarga) {
                return razonSocialCargaRepository.save(razonSocialCarga);

        }

        @PutMapping("/Actualiza_RzSocial/{id}")
        ResponseEntity<Razon_Social> ActualizarDatos(@PathVariable long id, @RequestBody Razon_Social razonSocialCarga) {
                Razon_Social ActualizarDatos = razonSocialCargaRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Razon Social not exist whith id:" + id));

                ActualizarDatos.setNombre(razonSocialCarga.getNombre());
                ActualizarDatos.setRfc(razonSocialCarga.getRfc());
                ActualizarDatos.setDireccion(razonSocialCarga.getDireccion());
                ActualizarDatos.setColonia(razonSocialCarga.getColonia());
                ActualizarDatos.setCp(razonSocialCarga.getCp());
                ActualizarDatos.setActivo(razonSocialCarga.getActivo());
                ActualizarDatos.setComercio_id(razonSocialCarga.getComercio_id());

                razonSocialCargaRepository.save(ActualizarDatos);

                return ResponseEntity.ok(ActualizarDatos);


        }

        @DeleteMapping("/Eliminar_RzSocial/{id}")
        public ResponseEntity<HttpStatus> deleteRzSocial(@PathVariable long id) {

                Razon_Social razonSocialCarga = razonSocialCargaRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Not found razon social: " + id));

                razonSocialCargaRepository.delete(razonSocialCarga);

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

}
